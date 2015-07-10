package com.techsen.tsweb.sys.dao;

import java.util.List;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.Auth;

@LocalMyBatisDao
public interface AuthDao extends Dao<Auth> {

    /**
     * 根据角色ID获取Auth集合
     */
    List<Auth> getAuthsByRoleId(String roleId);
    
    /**
     * 根据用户ID获取Auth集合
     */
    List<Auth> getAuthsByUserId(String userId);
    
    /**
     * 根据角色名获取Auth集合
     */
    public List<Auth> getAuthsByRoleName(String roleName);
    
}
