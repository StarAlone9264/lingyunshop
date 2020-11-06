package com.lingyun.config;

import com.lingyun.util.Md5UUIDSaltUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.context.annotation.Configuration;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/29 16:23
 * 重写密码匹配凭证
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        // 获取用户输入的密码
        String password = new String(usernamePasswordToken.getPassword());
        // 获取数据库中的密码
        String credentials = (String) info.getCredentials();
        // 判断
        return Md5UUIDSaltUtil.getSaltverifyMd5AndSha(password,credentials);
    }
}
