package com.qfedu.ordersystem.shiro;/*
package com.qfedu.com.qfedu.ordersystem.shiro;

import com.qf.springboot_shiro.mapper.UserMapper;
import com.qf.springboot_shiro.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

*/

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: CommonRbac
 * @description:
 * @author: Feri
 * @create: 2019-10-22 10:13
 */

@Component //Spring IOC创建对象
public class MyRealm extends AuthorizingRealm {
    //1、授权  查询登录用户的角色或者权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
      return null;
    }
    //2、认证 生成凭证 登录成功
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        if(token.getUsername()!=null){
            //登录成功
            AuthenticationInfo info=new SimpleAuthenticationInfo(token.getPrincipal(),token.getPassword(),getName());
            return info;
        }
        return null;
    }
}

