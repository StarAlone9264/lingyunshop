package com.lingyun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lingyun.dao.TbSellerDao;
import com.lingyun.entity.TbBrand;
import com.lingyun.entity.TbSeller;
import com.lingyun.service.TbSellerService;
import com.lingyun.util.Md5UUIDSaltUtil;
import com.lingyun.util.PageRequest;
import com.lingyun.util.PageResult;
import com.lingyun.util.PageUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * (TbSeller)表服务实现类
 *
 * @author makejava
 * @since 2020-10-28 17:09:40
 */
@DubboService
public class TbSellerServiceImpl implements TbSellerService {
    @Resource
    private TbSellerDao tbSellerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param sellerId 主键
     * @return 实例对象
     */
    @Override
    public TbSeller queryById(String sellerId) {
        return this.tbSellerDao.queryById(sellerId);
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
    public List<TbSeller> queryAll(String status) {
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbSeller> queryAllByLimit(int offset, int limit) {
        return this.tbSellerDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(TbSeller tbSeller) {
        TbSeller query = tbSellerDao.query(new TbSeller().setSellerId(tbSeller.getSellerId()));
        if (query != null) return query.getSellerId() + "已存在";
        if (tbSellerDao.insert(tbSeller.setPassword(Md5UUIDSaltUtil.getSaltMd5AndSha(tbSeller.getPassword())).setStatus("0")) > 0) return "success";
        return "error";
    }

    /**
     * 修改数据
     *
     * @param tbSeller 实例对象
     * @return 实例对象
     */
    @Override
    public String  update(TbSeller tbSeller) {
        if (tbSellerDao.update(tbSeller) > 0) return "success";
        return "error";
    }

    /**
     * 通过主键删除数据
     *
     * @param sellerId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String sellerId) {
        return this.tbSellerDao.deleteById(sellerId) > 0;
    }

    @Override
    public TbSeller query(TbSeller tbSeller) {
        return this.tbSellerDao.query(tbSeller);
    }

    /**
     * 调用分页插件完成分页
     * @param pageRequest pageRequest
     * @return PageInfo
     */
    private PageInfo<TbSeller> getPageInfo(Map map,PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<TbSeller> list = tbSellerDao.queryAll(map);
        for (TbSeller seller : list) {
            seller.setPassword("");
        }
        return new PageInfo<TbSeller>(list);
    }
}