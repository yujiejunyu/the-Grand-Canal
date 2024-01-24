package org.example.pojo;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDateTime;
//空参数构造
@NoArgsConstructor
//全参数构造方法
@AllArgsConstructor
@Data
public class User {
    @NonNull
    private Integer id;//主键ID
    private String username;//用户名
    @JsonIgnore
//    @JsonIgnoreProperties({"password"})//让当前对象转换成JSON字符串时，忽略password，最终返回JSON字符串没有password的这个属性
    private String password;//密码
    private String phone;//手机号
    @NotEmpty
    @Email
    private String email;//邮箱
//    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间


}
