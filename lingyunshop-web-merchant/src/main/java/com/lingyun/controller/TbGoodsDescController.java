package com.lingyun.controller;

import com.lingyun.entity.TbGoodsDesc;
import com.lingyun.service.TbGoodsDescService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbGoodsDesc)表控制层
 *
 * @author makejava
 * @since 2020-11-01 15:45:38
 */
@RestController
@RequestMapping("/tbGoodsDesc")
public class TbGoodsDescController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbGoodsDescService tbGoodsDescService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public TbGoodsDesc selectOne(Long id) {
        return this.tbGoodsDescService.queryById(id);
    }

}