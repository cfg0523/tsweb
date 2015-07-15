package com.techsen.tsweb.core.dao;

import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.core.util.sql.Pager;

/**
 * 公共的Dao接口
 */
public interface Dao<T extends BaseEntity<T>> {

    /**
     * 新增一个Entity
     */
    void add(T entity);

    /**
     * 根据id删除一个Entity
     */
    void delete(T entity);

    /**
     * 根据id更新一个Entity
     */
    void update(T entity);

    /**
     * 根据id查找一个Entity
     */
    T get(String id);
    
    /**
     * 根据给定条件查找一个Entity
     */
    T getOneByEntity(T entity);
    
    /**
     * 根据给定条件查找Entity集合
     */
    List<T> getListByEntity(T entity);
    
    /**
     * 查询所有的Entity
     */
    List<T> findAll();
    
    /**
     * 根据Pager对象查询对象集合
     */
    List<T> findByPager(Pager<T> pager);
    
    /**
     * 根据数据总数
     */
    int getTotalSizeByPager(Pager<T> pager);
    
}
