package com.techsen.tsweb.sys.service;

import com.techsen.tsweb.sys.auth.Resource;
import com.techsen.tsweb.sys.auth.ResourceType;

public interface ResourceService {

    /**
     * 根据资源类型和资源名获取资源
     */
    Resource getResourceByTypeAndName(ResourceType type, String name);
    
}
