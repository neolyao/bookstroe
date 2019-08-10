package com.neolyao.bookstore.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neolyao.bookstore.pojo.ImageCode;
import com.neolyao.bookstore.pojo.UserInfo;
import com.neolyao.bookstore.pojo.User;
import com.neolyao.bookstore.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class userController {
    public final static String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
    private SessionStrategy sessionStrategy=new HttpSessionSessionStrategy();
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/code/image/{var}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        ImageCode imageCode = userService.createImageCode();
        session.setAttribute("code",imageCode.getCode());
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        ImageIO.write(imageCode.getImage(), "jpeg", response.getOutputStream());
    }
    @PostMapping("/login")
    public String login( @RequestBody String logininfo){
        JSONObject object = JSON.parseObject(logininfo);
        String username=object.getString("username");
        String password=object.getString("password");
        UsernamePasswordToken token =new UsernamePasswordToken(username,password);
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return e.getMessage();
        } catch (IncorrectCredentialsException e) {
            return e.getMessage();
        } catch (LockedAccountException e) {
            return e.getMessage();
        } catch (AuthenticationException e) {
            return "认证失败！";
        }
        return "success";
    }
    @PostMapping("/regist")
    public  String regist(@RequestBody @Validated UserInfo userInfo,BindingResult result,HttpSession session ){
        System.out.println(userInfo);
        List<String> errors= new ArrayList<>();
        if (result.hasErrors()){
            List<ObjectError> allerror=result.getAllErrors();
            for (ObjectError error:allerror){
                System.out.println(error.getDefaultMessage());
            }
            return "信息有误,请输出正确信息";
        }
        if(!userInfo.getVcode().equals(session.getAttribute("code")))
            return "验证码不正确";
        if(userService.findByUserName(userInfo.getUsername())!=null)
            return "用户名已经存在";
        User user =new User();
        user.setUsername(userInfo.getUsername());
        user.setPassword(userInfo.getPassword());
        user.setEmail(userInfo.getEmail());
        user.setCreatetime(new Date());
        user.setStatus("1");
        userService.addUser(user);
        return "success";

    }
}
