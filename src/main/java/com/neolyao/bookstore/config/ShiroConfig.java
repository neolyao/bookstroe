package com.neolyao.bookstore.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;


@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();

        factoryBean.setLoginUrl("/login");
        factoryBean.setUnauthorizedUrl("/unauthorized");

        LinkedHashMap<String,String> filtermap= new LinkedHashMap<>();
        filtermap.put("/login","anon");
        filtermap.put("/regist","anon");
        filtermap.put("/logout", "logout");
        filtermap.put("/", "anon");
        filtermap.put("/code/image/**","anon");
        filtermap.put("/category","anon");
        filtermap.put("/**","authc");

        factoryBean.setFilterChainDefinitionMap(filtermap);
        factoryBean.setSecurityManager(securityManager());
        return factoryBean;
    }
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return  securityManager;
    }
    @Bean
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm=new ShiroRealm();
        return shiroRealm;
    }
}
