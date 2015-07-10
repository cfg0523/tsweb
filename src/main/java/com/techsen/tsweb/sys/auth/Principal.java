package com.techsen.tsweb.sys.auth;

public interface Principal {

    /**
     * 获取授权主体类型
     */
    PrincipalType getPrincipalType();
    
    /**
     * 获取授权主体ID
     */
    String getPrincipalId();
    
}
