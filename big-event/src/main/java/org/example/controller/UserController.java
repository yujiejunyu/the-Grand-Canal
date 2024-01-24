package org.example.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.example.pojo.Result;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.JwtUtil;
import org.example.utils.Md5Util;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //注册
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{3,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password ,
                           @Pattern(regexp = "^\\S{3,11}$")String phone,/*@Pattern(regexp ="^\\S{5,16}$" )*/@Email String email){
        //查询用户
        User u=userService.findByIdUserName(username);
        if(u==null){
            //注册
            userService.register(username,password,phone,email);
            return Result.success();
        }else {
            return Result.error("用户名已被占用");
        }
    }
    //登入
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password ){
        //根据用户名查询
        User loginUser=userService.findByIdUserName(username);
        //判断用户是否存在
        if(loginUser==null){
            return Result.error("用户名错误");
        }
        //判断密码是否正确
        if(Md5Util.getMD5String(password).equals(loginUser.getPassword())){
            //登入成功
            Map<String,Object> claims =new HashMap<>();
            claims.put("id",loginUser.getId());
            claims.put("username",loginUser.getUsername());
            String token= JwtUtil.genToken(claims);
            //把token存储到redis
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token,token,1, TimeUnit.HOURS);
            return Result.success(token);
        }

        return Result.error("账号密码错误");
    }
    //获取用户信息
    @GetMapping("/userInfo")
    public Result<User> userInfo(){
        //根据用户名查询用户
        Map<String,Object>map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user =userService.findByIdUserName(username);

        return Result.success(user);
    }
    //更新用户信息
    @PostMapping("/update")
    public Result update(@RequestBody @Validated User user){
        userService.update(user);
        return Result.success();
    }
    //修改密码
    @PatchMapping ("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,String> params,@RequestHeader("Authorization") String token){
        //校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");
        if(!StringUtils.hasLength(oldPwd)||!StringUtils.hasLength(newPwd)||!StringUtils.hasLength(rePwd)){
            return Result.error("密码未填写");
        }
        //原密码是否正确
        //调用UserService原用户密码，和oldpwd对比
        Map<String,Object> map=ThreadLocalUtil.get();
        String username= (String) map.get("username");
        User loginuser = userService.findByIdUserName(username);
        if ( !loginuser.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            return Result.error("原密码填写错误");
        }
        //newpwd和repwd
        if (!rePwd.equals(newPwd)){
            return Result.error("俩次密码不正确");
        }
        //调用service完成密码更新
        userService.update(newPwd);
        //删除redis中的token
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(token);
        return Result.success();
    }
}
