package com.example.springbootchatroom.code.config;

import com.example.springbootchatroom.code.filter.JwtFilter;
import com.example.springbootchatroom.code.realm.UserRealm;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * shiro权限框架配置类
 */
@Configuration
public class ShiroConfig {

    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(manager);
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt",new JwtFilter());
        factoryBean.setFilters(filterMap);
        factoryBean.setUnauthorizedUrl("/");
        Map<String,String>filterRuleMap =new HashMap<>();
        //设置需要拦截的请求
        filterRuleMap.put("/**","jwt");
        //不需要拦截的请求
        filterRuleMap.put("/base/**","anon");
        //设置需要认证的
        factoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return factoryBean;
    }

    @Bean(name = "manager")
    public DefaultWebSecurityManager getSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }

    @Bean(name = "userRealm")
    public UserRealm getUserRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }
}
