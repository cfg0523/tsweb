package com.techsen.tsweb.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.core.service.impl.BaseService;
import com.techsen.tsweb.sys.dao.UserDao;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.UserService;

@Service
public class UserServiceImpl extends BaseService<User, UserDao> implements UserService {

    @Override
    @Resource
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    /**
     * 修改用户密码
     */
    @Override
    public void changePassword(User user) {
        this.dao.changePassword(user);
    }

}
