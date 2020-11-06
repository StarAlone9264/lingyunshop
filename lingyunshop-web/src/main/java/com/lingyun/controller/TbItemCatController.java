package com.lingyun.controller;

import com.lingyun.entity.TbItemCat;
import com.lingyun.service.TbItemCatService;
import com.lingyun.util.Result;
import com.lingyun.util.ResultGenerator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 商品类目(TbItemCat)表控制层
 *
 * @author makejava
 * @since 2020-10-31 14:15:26
 */
@RestController
@RequestMapping("/tbItemCat")
public class TbItemCatController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbItemCatService tbItemCatService;


    @GetMapping("/list")
    public Result query(@RequestParam Map<String,Object> map){
        return ResultGenerator.genSuccessResult(tbItemCatService.queryPage(map));
    }
    @PostMapping(value = "/add",produces="application/json;charset=UTF-8")
    public Result add(@RequestBody TbItemCat tbItemCat){
        return ResultGenerator.genSuccessResult(tbItemCatService.insert(tbItemCat));
    }

    @PostMapping(value = "/update",produces="application/json;charset=UTF-8")
    public Result update(@RequestBody TbItemCat tbItemCat){
        return ResultGenerator.genSuccessResult(tbItemCatService.update(tbItemCat));
    }
}