//package com.lingyun.com.lingyun.controller;
//
//import com.lingyun.entity.TbAddress;
//import com.lingyun.service.TbAddressService;
//import com.lingyun.util.Result;
//import com.lingyun.util.ResultGenerator;
//import org.apache.dubbo.com.lingyun.config.annotation.DubboReference;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//
///**
// * (TbAddress)表控制层
// *
// * @author makejava
// * @since 2020-10-19 00:30:21
// */
//@RestController
//@RequestMapping("/tbAddress")
//public class TbAddressController {
//    /**
//     * 服务对象
//     */
//    @DubboReference
//    private TbAddressService tbAddressService;
//
//    /**
//     * 通过主键查询单条数据
//     *
//     * @param id 主键
//     * @return 单条数据
//     */
//    @GetMapping("/selectOne")
//    public TbAddress selectOne(Long id) {
//        return this.tbAddressService.queryById(id);
//    }
//
//    @GetMapping("/selectAll")
//    public Result selectAll(){
//        return ResultGenerator.genSuccessResult(this.tbAddressService.queryAllByLimit(1,10));
//    }
//}