package com.techsen.tsweb.sys.dao;

import com.techsen.tsweb.core.annotation.LocalMyBatisDao;
import com.techsen.tsweb.core.dao.Dao;
import com.techsen.tsweb.sys.domain.User;

@LocalMyBatisDao
public interface UserDao extends Dao<User> {

    /**
     * 修改用户密码
     */
    void changePassword(User user);
    
}
