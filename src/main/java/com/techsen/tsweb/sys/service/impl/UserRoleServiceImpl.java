package com.techsen.tsweb.sys.service.impl;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.dao.UserRoleDao;
import com.techsen.tsweb.sys.domain.UserRole;
import com.techsen.tsweb.sys.service.UserRoleService;

@Service
public class UserRoleServiceImpl extends BaseService<UserRole, UserRoleDao> implements UserRoleService {

    @Override
    public void setDao(UserRoleDao dao) {
        this.dao = dao;
    }

}