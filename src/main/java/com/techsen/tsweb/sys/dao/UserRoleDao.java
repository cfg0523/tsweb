package com.techsen.tsweb.sys.dao;

import java.util.List;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.UserRole;

@LocalMyBatisDao
public interface UserRoleDao extends Dao<UserRole> {

    /**
     * 根据用户ID获取角色集合
     */
    public List<UserRole> getUserRolesByUserId(String userId);
    
    /**
     * 根据角色ID获取用户集合
     */
    public List<UserRole> getUserRolesByRoleId(String roleId);
}
