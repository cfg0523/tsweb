package com.techsen.tsweb.core.service;

import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.core.util.sql.Pager;

public interface Service<T extends BaseEntity<T>> {

    /**
     * 新增一个Entity
     */
    public T add(T entity);
    
    /**
     * 根据id删除一个Entity
     */
    public void delete(T entity);
    
    /**
     * 根据id更新一个Entity
     */
    public void update(T entity);
    
    /**
     * 根据id查找一个Entity
     */
    public T get(String id);
    
    /**
     * 根据给定条件查找一个Entity
     */
    public T getOneByEntity(T entity);
    
    /**
     * 根据给定条件查找Entity集合
     */
    public List<T> getListByEntity(T entity);
    
    /**
     * 查询所有的Entity
     */
    public List<T> findAll();
    
    /**
     * 分页查询集合对象
     */
    public Pager<T> findByPager(Pager<T> pager);
}
