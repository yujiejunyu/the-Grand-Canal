package org.example.service;

import jakarta.validation.constraints.Pattern;
import org.example.pojo.User;

public interface UserService {
    //根据用户名查询
    User findByIdUserName(String username);
    //注册
    void register(String username, String password, String phone,String email);
    //更新
    void update(User user);
    //更新密码

    void update(String newPwd);
}
