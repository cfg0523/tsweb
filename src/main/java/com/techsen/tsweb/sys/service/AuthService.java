package com.techsen.tsweb.sys.service;

import java.util.List;

import com.techsen.tsweb.core.service.Service;
import com.techsen.tsweb.sys.domain.Auth;

public interface AuthService extends Service<Auth> {

    /**
     * 根据用户ID获取Auth集合
     */
    public List<Auth> getAuthsByUserId(String userId);
    
}
