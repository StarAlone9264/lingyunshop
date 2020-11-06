package com.lingyun.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingyun.entity.TbGoods;
import com.lingyun.service.TbGoodsService;
import com.lingyun.util.Result;
import com.lingyun.util.ResultGenerator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbGoods)表控制层
 *
 * @author makejava
 * @since 2020-11-01 15:44:05
 */
@RestController
@RequestMapping("/tbGoods")
public class TbGoodsController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbGoodsService tbGoodsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public TbGoods selectOne(Long id) {
        return this.tbGoodsService.queryById(id);
    }


    @PostMapping(value = "/add",produces="application/json;charset=UTF-8")
    public Result add(@RequestBody JSONObject object){
        System.out.println(object);
        return ResultGenerator.genSuccessResult();
    }

}