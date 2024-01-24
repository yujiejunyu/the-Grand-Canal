package org.example.service.impl;

import jakarta.validation.constraints.Pattern;
import org.example.mapper.UserMapper;
import org.example.pojo.User;
import org.example.service.UserService;
import org.example.utils.Md5Util;
import org.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByIdUserName(String username) {
        User u=userMapper.findUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password, String phone,  String email) {
        //加密
        String md5String= Md5Util.getMD5String(password);
        userMapper.add(username,md5String,phone,email);
        //添加
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void update(String newPwd) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id= (Integer) map.get("id");
        userMapper.updatePwd(Md5Util.getMD5String(newPwd),id);
    }
}
