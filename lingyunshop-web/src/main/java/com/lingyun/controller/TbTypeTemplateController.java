package com.lingyun.controller;

import com.lingyun.entity.TbTypeTemplate;
import com.lingyun.service.TbTypeTemplateService;
import com.lingyun.util.PageRequest;
import com.lingyun.util.Result;
import com.lingyun.util.ResultGenerator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbTypeTemplate)表控制层
 * @author makejava
 * @since 2020-10-25 12:23:59
 */
@RestController
@RequestMapping("/tbTypeTemplate")
public class TbTypeTemplateController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbTypeTemplateService tbTypeTemplateService;

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public TbTypeTemplate selectOne(Long id) {
        return this.tbTypeTemplateService.queryById(id);
    }

    @GetMapping("/list")
    public Result queryAllByLimit(Integer offset,Integer limit){
        return ResultGenerator.genSuccessResult(tbTypeTemplateService.queryAllByLimit(new PageRequest(offset,limit)));
    }
    @PostMapping(value = "/insert",produces="application/json;charset=UTF-8")
    public Result insert(@RequestBody TbTypeTemplate tbTypeTemplate){
        return ResultGenerator.genSuccessResult(tbTypeTemplateService.insert(tbTypeTemplate));
    }

    /**
     * 依据id进行删除/多选删除
     * @param ids ids
     * @return Result
     */
    @PostMapping("/dycDelByIds")
    public Result dycDelByIds(@RequestBody List<Long> ids){
        return ResultGenerator.genSuccessResult(tbTypeTemplateService.dycDelByIds(ids));
    }

    /**
     * 修改
     * @param tbTypeTemplate 对象
     * @return Result
     */
    @PostMapping(value = "/update",produces="application/json;charset=UTF-8")
    public Result update(@RequestBody TbTypeTemplate tbTypeTemplate){
        return ResultGenerator.genSuccessResult(tbTypeTemplateService.update(tbTypeTemplate));
    }

    @GetMapping("/query")
    public Result list(TbTypeTemplate tbTypeTemplate){
        return ResultGenerator.genSuccessResult(tbTypeTemplateService.queryAll(tbTypeTemplate));
    }
}