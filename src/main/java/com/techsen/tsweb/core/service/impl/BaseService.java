package com.techsen.tsweb.core.service.impl;

import java.util.List;

import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.core.service.Service;

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
    public E getByEntity(E entity) {
        return this.dao.getByEntity(entity);
    }

    /**
     * 查询所有的Entity
     */
    @Override
    public List<E> findAll() {
        return this.dao.findAll();
    }
}
