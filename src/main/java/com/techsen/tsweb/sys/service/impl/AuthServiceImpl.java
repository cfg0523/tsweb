package com.techsen.tsweb.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.dao.AuthDao;
import com.techsen.tsweb.sys.domain.Auth;
import com.techsen.tsweb.sys.service.AuthService;

@Service
public class AuthServiceImpl extends BaseService<Auth, AuthDao> implements AuthService {

    @Override
    @Resource
    public void setDao(AuthDao dao) {
        this.dao = dao;
    }

    /**
     * 根据用户ID获取Auth集合
     */
    @Override
    public List<Auth> getAuthsByUserId(String userId) {
        return this.dao.getAuthsByUserId(userId);
    }

    /**
     * 根据角色ID获取Auth集合
     */
    @Override
    public List<Auth> getAuthsByRoleId(String roleId) {
        return this.dao.getAuthsByRoleId(roleId);
    }
    
    /**
     * 根据角色名获取Auth集合
     */
    @Override
    public List<Auth> getAuthsByRoleName(String roleName) {
        return this.dao.getAuthsByRoleName(roleName);
    }

}
