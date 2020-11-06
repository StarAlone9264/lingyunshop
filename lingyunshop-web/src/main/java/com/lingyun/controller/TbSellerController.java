package com.lingyun.controller;

import com.lingyun.entity.TbSeller;
import com.lingyun.service.TbSellerService;
import com.lingyun.util.PageRequest;
import com.lingyun.util.Result;
import com.lingyun.util.ResultGenerator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 商家入驻
     * @param tbSeller tbSeller
     * @return Result
     */
    @PostMapping(value = "/add",produces="application/json;charset=UTF-8")
    public Result add(@RequestBody TbSeller tbSeller){
        return ResultGenerator.genSuccessResult(tbSellerService.insert(tbSeller));
    }

    @GetMapping("/queryBusiness")
    public Result queryByStatus(@RequestParam Map<String,String> map){
        return ResultGenerator.genSuccessResult(tbSellerService.queryPage(map));
    }

    @PostMapping(value = "/update",produces = "application/json;charset=UTF-8")
    public Result operating(@RequestBody TbSeller tbSeller){
        return ResultGenerator.genSuccessResult(tbSellerService.update(tbSeller));
    }

}