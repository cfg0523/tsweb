package com.techsen.tsweb.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.dao.UserRoleDao;
import com.techsen.tsweb.sys.domain.UserRole;
import com.techsen.tsweb.sys.service.UserRoleService;

@Service
public class UserRoleServiceImpl extends BaseService<UserRole, UserRoleDao> implements UserRoleService {

    @Override
    @Resource
    public void setDao(UserRoleDao dao) {
        this.dao = dao;
    }

    /**
     * 根据用户ID获取UserRole集合
     */
    @Override
    public List<UserRole> getUserRolesByUserId(String userId) {
        
        return this.dao.getUserRolesByUserId(userId);
    }

    /**
     * 根据RoleID获取UserRole集合
     */
    @Override
    public List<UserRole> getUserRolesByRoleId(String roleId) {
        return this.dao.getUserRolesByRoleId(roleId);
    }

}
