package com.neolyao.bookstore.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserInfo {
    @NotBlank(message = "用户名不能为空")
    private  String username;
    @NotBlank(message = "密码不能为空")
    private  String password;
    @NotBlank(message = "确认密码不能为空")
    private  String repassword;
    @Email(message = "邮箱格式不对")
    @NotBlank(message = "邮箱不能为空")
    private  String email;
    @NotBlank(message = "验证码不能为空")
    private  String vcode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                ", email='" + email + '\'' +
                ", vcode='" + vcode + '\'' +
                '}';
    }
}
