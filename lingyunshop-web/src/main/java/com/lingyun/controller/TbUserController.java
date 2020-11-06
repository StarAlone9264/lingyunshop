package com.lingyun.controller;

import com.lingyun.entity.TbUser;
import com.lingyun.service.TbUserService;
import com.lingyun.util.Result;
import com.lingyun.util.ResultGenerator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/26 15:54
 */
@RestController
@RequestMapping("/user")
public class TbUserController {

    @DubboReference
    private TbUserService tbUserService;

    @GetMapping("/login")
    public Result login(){
        return ResultGenerator.genErrorResult(403,"登陆信息失效，请重新登陆");
    }

    @PostMapping(value = "/login",produces="application/json;charset=UTF-8")
    public Result login(@RequestBody TbUser tbUser){
        Subject subject = SecurityUtils.getSubject();
        // 如果存在用户 则 踢出
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        UsernamePasswordToken token = new UsernamePasswordToken(tbUser.getUsername(), tbUser.getPassword(),true);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResultGenerator.genFailResult("用户名不存在!");
        } catch (IncorrectCredentialsException e) {
            return ResultGenerator.genFailResult("密码错误!");
        }
        Long principal = (Long) SecurityUtils.getSubject().getPrincipal();
        TbUser userInfo = tbUserService.queryById(principal);
        if ("0".equals(userInfo.getStatus())) {
            return ResultGenerator.genFailResult("您的账号已被锁定，请联系网站管理员");
        }
        return ResultGenerator.genSuccessResult(userInfo);
    }

    @GetMapping("/loginOut")
    public Result loginOut(){
        SecurityUtils.getSubject().logout();
        return ResultGenerator.genSuccessResult();
    }
}
