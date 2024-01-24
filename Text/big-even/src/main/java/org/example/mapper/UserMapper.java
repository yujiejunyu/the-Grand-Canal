package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.User;

@Mapper
public interface UserMapper {
    //根据用户名查询
    @Select("select * from user where username=#{username}")
    User findUserName(@Param("username")String username);
    //添加
    @Insert("insert into user(username,password,phone,email,create_time,update_time) values(#{username},#{password},#{phone},#{email},now(),now())")
    void add(@Param("username") String username, @Param("password")String password, @Param("phone") String phone,@Param("email")String email);
    //修改信息
    @Update("update user set username=#{username},phone=#{phone},email=#{email},update_time=#{updateTime} where id=#{id}")
    void update(User user);
    //修改密码
    @Update("update user set password=#{md5String},update_time=now() where id=#{id}")
    void updatePwd(String md5String, Integer id);
}
