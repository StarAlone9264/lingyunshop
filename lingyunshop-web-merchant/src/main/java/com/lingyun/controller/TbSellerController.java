package com.lingyun.controller;

import com.lingyun.entity.TbSeller;
import com.lingyun.service.TbSellerService;
import com.lingyun.util.Result;
import com.lingyun.util.ResultGenerator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbSeller)表控制层
 *
 * @author makejava
 * @since 2020-10-28 17:10:29
 */
@RestController
@RequestMapping("/tbSeller")
public class TbSellerController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbSellerService tbSellerService;

    @PostMapping(value = "/login",produces="application/json;charset=UTF-8")
    public Result login(@RequestBody TbSeller tbSeller){
        Subject subject = SecurityUtils.getSubject();
        // 如果存在用户 则 踢出
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        UsernamePasswordToken token = new UsernamePasswordToken(tbSeller.getSellerId(), tbSeller.getPassword(),true);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResultGenerator.genFailResult("用户名不存在!");
        } catch (IncorrectCredentialsException e) {
            return ResultGenerator.genFailResult("密码错误!");
        }
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        TbSeller seller = tbSellerService.queryById(principal);
        if ("0".equals(seller.getStatus())) {
            return ResultGenerator.genFailResult("您的账号暂未通过未审核，请耐心等待");
        }
        if ("2".equals(seller.getStatus())) {
            return ResultGenerator.genFailResult("您的账号审核未通过，请重试");
        }
        if ("3".equals(seller.getStatus())) {
            return ResultGenerator.genFailResult("您的账号已被封禁，如需恢复请联系管理员");
        }
        return ResultGenerator.genSuccessResult(seller.setPassword(null));
    }

    @PostMapping(value = "/register",produces="application/json;charset=UTF-8")
    public Result add(@RequestBody TbSeller tbSeller){
        return ResultGenerator.genSuccessResult(tbSellerService.insert(tbSeller));
    }

    @GetMapping("/loginOut")
    public Result loginOut(){
        SecurityUtils.getSubject().logout();
        return ResultGenerator.genSuccessResult();
    }
}