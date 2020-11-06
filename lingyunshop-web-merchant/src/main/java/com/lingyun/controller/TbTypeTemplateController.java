package com.lingyun.controller;

import com.lingyun.entity.TbTypeTemplate;
import com.lingyun.service.TbTypeTemplateService;
import com.lingyun.util.Result;
import com.lingyun.util.ResultGenerator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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


    @GetMapping("/query")
    public Result list(Long id){
        return ResultGenerator.genSuccessResult(tbTypeTemplateService.queryAll(new TbTypeTemplate().setId(id)));
    }

}