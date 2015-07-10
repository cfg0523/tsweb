package com.techsen.tsweb.sys.auth;

public interface Resource {

    /**
     * 获取资源类型
     */
    ResourceType getResourceType();
    
    /**
     * 获取资源组名称
     */
    String getResourceGroup();
    
    /**
     * 获取资源授权码
     */
    int getAuthCode();
}
