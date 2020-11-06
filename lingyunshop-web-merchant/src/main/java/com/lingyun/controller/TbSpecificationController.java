package com.lingyun.controller;

import com.lingyun.entity.vo.TbSpecificationOptionVo;
import com.lingyun.service.TbSpecificationService;
import com.lingyun.util.PageRequest;
import com.lingyun.util.Result;
import com.lingyun.util.ResultGenerator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/queryListById")
    public Result batchQuery(@RequestParam List<Long> ids){
        return ResultGenerator.genSuccessResult(tbSpecificationService.batchQuery(ids));
    }

}
