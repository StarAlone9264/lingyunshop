package com.lingyun.service.impl;

import com.lingyun.dao.TbAddressDao;
import com.lingyun.entity.TbAddress;
import com.lingyun.service.TbAddressService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbAddress)表服务实现类
 *
 * @author makejava
 * @since 2020-10-19 00:27:52
 */
@DubboService
public class TbAddressServiceImpl implements TbAddressService {
    @Resource
    private TbAddressDao tbAddressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbAddress queryById(Long id) {
        return this.tbAddressDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TbAddress> queryAllByLimit(int offset, int limit) {
        return this.tbAddressDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbAddress 实例对象
     * @return 实例对象
     */
    @Override
    public TbAddress insert(TbAddress tbAddress) {
        this.tbAddressDao.insert(tbAddress);
        return tbAddress;
    }

    /**
     * 修改数据
     *
     * @param tbAddress 实例对象
     * @return 实例对象
     */
    @Override
    public TbAddress update(TbAddress tbAddress) {
        this.tbAddressDao.update(tbAddress);
        return this.queryById(tbAddress.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tbAddressDao.deleteById(id) > 0;
    }
}