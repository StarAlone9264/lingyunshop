package com.lingyun.controller;

import com.lingyun.entity.TbBrand;
import com.lingyun.service.TbBrandService;
import com.lingyun.util.PageRequest;
import com.lingyun.util.Result;
import com.lingyun.util.ResultGenerator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * (TbBrand)表控制层
 *
 * @author makejava
 * @since 2020-10-21 00:51:18
 */
@RestController
@RequestMapping("/tbBrand")
public class TbBrandController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbBrandService tbBrandService;

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public TbBrand selectOne(Long id) {
        return this.tbBrandService.queryById(id);
    }

    /**
     * 分页查询
     * @param offset 页数
     * @param limit 条数
     * @return Result
     */
    @GetMapping("/list")
    public Result list(Integer offset,Integer limit){
        return ResultGenerator.genSuccessResult(tbBrandService.queryPage(new PageRequest(offset,limit)));
    }

    /**
     * 依据id进行删除/多选删除
     * @param ids ids
     * @return Result
     */
    @PostMapping("/dycDelByIds")
    public Result dycDelByIds(@RequestBody List<Long> ids){
        return ResultGenerator.genSuccessResult(tbBrandService.dycDelByIds(ids));
    }

    /**
     * 添加
     * @param tbBrand 首字母/大写
     * @return Result
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody TbBrand tbBrand){
        String str = tbBrandService.insert(new TbBrand(tbBrand.getName(), tbBrand.getFirstChar().toUpperCase()));
        if ("existed".equals(str)) return ResultGenerator.genFailResult(str);
        if ("error".equals(str)) return ResultGenerator.genFailResult(str);
        if ("success".equals(str)) return ResultGenerator.genSuccessResult(str);
        return ResultGenerator.genFailResult("遇到了未知的错误~~~");
    }

    /**
     * 依据id修改
     * @param tbBrand tbBrand
     * @return Result
     */
    @PostMapping("/update")
    public Result update(TbBrand tbBrand){
        System.out.println(tbBrand);
        String update = tbBrandService.update(tbBrand);
        if ("null".equals(update)) return ResultGenerator.genFailResult(update);
        if ("error".equals(update)) return ResultGenerator.genFailResult(update);
        if ("success".equals(update)) return ResultGenerator.genSuccessResult(update);
        return ResultGenerator.genFailResult("遇到了未知的错误~~~");
    }
    @GetMapping("/queryAll")
    public Result queryAll(){
        return ResultGenerator.genSuccessResult(tbBrandService.queryAll(null));
    }
}