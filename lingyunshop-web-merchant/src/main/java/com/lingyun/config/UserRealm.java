package com.lingyun.config;

import com.lingyun.entity.TbSeller;
import com.lingyun.entity.TbUser;
import com.lingyun.service.TbSellerService;
import com.lingyun.service.TbUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author Star
 * @version 1.0
 * @date 2020/6/20 19:03
 */
public class UserRealm extends AuthorizingRealm {

    @DubboReference
    private TbSellerService tbSellerService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        TbSeller login = tbSellerService.query(new TbSeller().setSellerId(usernamePasswordToken.getUsername()));
        if (login == null){
            return null;
        }
        return new SimpleAuthenticationInfo(login.getSellerId(), login.getPassword(), getName());
    }

}
