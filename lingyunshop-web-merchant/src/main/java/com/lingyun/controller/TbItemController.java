package com.lingyun.controller;

import com.lingyun.entity.TbItem;
import com.lingyun.service.TbItemService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品表(TbItem)表控制层
 *
 * @author makejava
 * @since 2020-11-01 15:51:31
 */
@RestController
@RequestMapping("/tbItem")
public class TbItemController {
    /**
     * 服务对象
     */
    @DubboReference
    private TbItemService tbItemService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public TbItem selectOne(Long id) {
        return this.tbItemService.queryById(id);
    }

}