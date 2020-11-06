package com.lingyun.controller;

import com.lingyun.entity.TbItemCat;
import com.lingyun.service.TbItemCatService;
import com.lingyun.util.Result;
import com.lingyun.util.ResultGenerator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/getCategories")
    public Result getCategories(Long parentId){
        return ResultGenerator.genSuccessResult(tbItemCatService.query(parentId));
    }
}