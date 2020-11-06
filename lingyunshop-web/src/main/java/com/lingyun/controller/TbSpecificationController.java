package com.lingyun.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lingyun.entity.TbSpecificationOption;
import com.lingyun.entity.vo.TbSpecificationOptionVo;
import com.lingyun.service.TbSpecificationService;
import com.lingyun.util.PageRequest;
import com.lingyun.util.Result;
import com.lingyun.util.ResultGenerator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Star
 * @version 1.0
 * @date 2020/10/22 0:37
 */
@RestController
@RequestMapping("/tbSpecification")
public class TbSpecificationController {

    @DubboReference
    private TbSpecificationService tbSpecificationService;

    @GetMapping("/list")
    public Result queryAll(Integer offset,Integer limit){
        return ResultGenerator.genSuccessResult(tbSpecificationService.queryAll(new PageRequest(offset,limit)));
    }

    @PostMapping(value = "/dycDelByIds",produces="application/json;charset=UTF-8")
    public Result dycDelByIds(@RequestBody List<Long> ids){
        return ResultGenerator.genSuccessResult(tbSpecificationService.dycDelByIds(ids));
    }

    @PostMapping(value = "/insert",produces="application/json;charset=UTF-8")
    public Result insert(@RequestBody TbSpecificationOptionVo tbSpecificationOptionVo){
        return ResultGenerator.genSuccessResult(tbSpecificationService.insert(tbSpecificationOptionVo));
    }

    @PostMapping(value = "/update",produces="application/json;charset=UTF-8")
    public Result update(@RequestBody TbSpecificationOptionVo tbSpecificationOptionVo){
        return ResultGenerator.genSuccessResult(tbSpecificationService.update(tbSpecificationOptionVo));
    }
    @GetMapping("/queryAll")
    public Result queryAll(){
        return ResultGenerator.genSuccessResult(tbSpecificationService.list());
    }
}
