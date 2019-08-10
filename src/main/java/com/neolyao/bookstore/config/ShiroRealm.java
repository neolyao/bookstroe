package com.neolyao.bookstore.config;


import com.neolyao.bookstore.pojo.User;
import com.neolyao.bookstore.service.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserServiceImpl userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username=(String)token.getPrincipal();
        String password=new String((char[])token.getCredentials());
        System.out.println("用户" + username + "认证-----ShiroRealm.doGetAuthenticationInfo");
        User user =userService.findByUserName(username);
        if(user==null){
            throw new UnknownAccountException("用户名不存在");
        }
        if(!password.equals(user.getPassword())){
            throw new IncorrectCredentialsException("用户名或密码错误");
        }
        if(user.getStatus().equals("0")){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        return info;
    }
}
