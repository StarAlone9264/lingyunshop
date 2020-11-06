package com.lingyun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lingyun.dao.TbItemCatDao;
import com.lingyun.entity.TbItemCat;
import com.lingyun.entity.TbSeller;
import com.lingyun.service.TbItemCatService;
import com.lingyun.util.PageRequest;
import com.lingyun.util.PageResult;
import com.lingyun.util.PageUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品类目(TbItemCat)表服务实现类
 *
 * @author makejava
 * @since 2020-10-31 14:14:47
 */
@DubboService
public class TbItemCatServiceImpl implements TbItemCatService {
    @Resource
    private TbItemCatDao tbItemCatDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbItemCat queryById(Long id) {
        return this.tbItemCatDao.queryById(id);
    }

    @Override
    public PageResult queryPage(Map map) {
        String offset = (String) map.get("offset");
        String limit = (String) map.get("limit");
        PageRequest pageRequest = new PageRequest(Integer.parseInt(offset),Integer.parseInt(limit));
        map.remove("offset");
        map.remove("limit");
        return PageUtils.getPageResult(pageRequest, getPageInfo(map,pageRequest));
    }

    @Override
    public List<TbItemCat> query(Long id) {
        Map<String,Long> map = new HashMap<>();
        map.put("parentId",id);
        return tbItemCatDao.queryAll(map);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbItemCat> queryAllByLimit(int offset, int limit) {
        return this.tbItemCatDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbItemCat 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(TbItemCat tbItemCat) {
        if (tbItemCatDao.insert(tbItemCat) > 0) return "success";
        return "error";
    }

    /**
     * 修改数据
     *
     * @param tbItemCat 实例对象
     * @return 实例对象
     */
    @Override
    public String update(TbItemCat tbItemCat) {
        if (tbItemCatDao.update(tbItemCat) > 0) return "success";
        return "error";
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbItemCatDao.deleteById(id) > 0;
    }


    /**
     * 调用分页插件完成分页
     * @param pageRequest pageRequest
     * @return PageInfo
     */
    private PageInfo<TbItemCat> getPageInfo(Map map, PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<TbItemCat> list = tbItemCatDao.queryAll(map);
        return new PageInfo<TbItemCat>(list);
    }
}