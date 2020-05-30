package com.keji.common.config;

import com.keji.pojo.UserInfo;
import com.keji.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dcy
 * @date 2019/9/10 14:06
 * @description
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token  = (UsernamePasswordToken) authenticationToken;
        UserInfo userInfo = userService.findUserByUserName(token.getUsername());
        if(userInfo==null){
            return null;
        }
        return new SimpleAuthenticationInfo(userInfo,userInfo.getPassword(),"");
    }
}
