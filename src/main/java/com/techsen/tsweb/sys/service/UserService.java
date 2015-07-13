package com.techsen.tsweb.sys.service;

import com.techsen.tsweb.core.service.Service;
import com.techsen.tsweb.sys.domain.User;

public interface UserService extends Service<User> {

    /**
     * 修改用户密码
     */
    public void changePassword(User user);
    
}
