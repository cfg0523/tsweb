package com.techsen.tsweb.sys.service;

import java.util.List;

import com.techsen.tsweb.core.service.Service;
import com.techsen.tsweb.sys.domain.UserRole;

public interface UserRoleService extends Service<UserRole> {

    /**
     * 根据用户ID获取UserRole集合
     */
    List<UserRole> getUserRolesByUserId(String userId);

    /**
     * 根据RoleID获取UserRole集合
     */
    List<UserRole> getUserRolesByRoleId(String roleId);
    
}
