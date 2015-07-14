package com.techsen.tsweb.core.service.impl;

import java.util.List;

import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.core.service.Service;
import com.techsen.tsweb.core.util.sql.Pager;

public abstract class BaseService<E extends BaseEntity<E>, T extends Dao<E>>
        implements Service<E> {

    protected T dao;
    
    public abstract void setDao(T dao);

    /**
     * 新增一个Entity
     */
    @Override
    public E add(E entity) {
        this.dao.add(entity);
        return entity;
    }

    /**
     * 根据id删除一个Entity
     */
    @Override
    public void delete(E entity) {
        this.dao.delete(entity);
    }

    /**
     * 根据id更新一个Entity
     */
    @Override
    public void update(E entity) {
        this.dao.update(entity);
    }

    /**
     * 根据id查找一个Entity
     */
    @Override
    public E get(String id) {
        return this.dao.get(id);
    }

    /**
     * 根据给定条件查找一个Entity
     */
    @Override
    public E getOneByEntity(E entity) {
        return this.dao.getOneByEntity(entity);
    }

    /**
     * 根据给定条件查找Entity集合
     */
    @Override
    public List<E> getListByEntity(E entity) {
        return this.dao.getListByEntity(entity);
    }
    
    /**
     * 查询所有的Entity
     */
    @Override
    public List<E> findAll() {
        return this.dao.findAll();
    }
    
    /**
     * 分页查询集合对象
     */
    public Pager<E> findByPager(Pager<E> pager) {
        List<E> entities = this.dao.findBySql(pager);
        int totalsize = this.dao.getTotalSize();
        pager.setEntities(entities).setTotalsize(totalsize);
        return pager;
    }
}
