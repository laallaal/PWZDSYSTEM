package com.qfedu.ordersystem.config;



import com.qfedu.ordersystem.shiro.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    @Bean
    public DefaultWebSecurityManager createSM(MyRealm myRealm) {

        DefaultWebSecurityManager manager = new DefaultWebSecurityManager(myRealm);

        return manager;

    }


    @Bean
    public ShiroFilterFactoryBean createSF(DefaultWebSecurityManager manager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();


        shiroFilterFactoryBean.setSecurityManager(manager);

        shiroFilterFactoryBean.setLoginUrl("login.html");
        shiroFilterFactoryBean.setSuccessUrl("index.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("error.html");

        Map<String, String> map = new HashMap<>();

        map.put("/login.html","anon");
        map.put("/user/login.do","anon");
        map.put("/static/media/*","anon");

        map.put("/*","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;

    }

}
