package com.techsen.tsweb.sys.service.impl;

import org.springframework.stereotype.Service;

import com.techsen.tsweb.sys.auth.Resource;
import com.techsen.tsweb.sys.auth.ResourceType;
import com.techsen.tsweb.sys.dao.MenuDao;
import com.techsen.tsweb.sys.domain.Menu;
import com.techsen.tsweb.sys.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

    @javax.annotation.Resource
    private MenuDao menuDao;
    
    @Override
    public Resource getResourceByTypeAndName(ResourceType type, String name) {
        Resource resource = null;
        if (ResourceType.menu.equals(type)) {
            resource = this.menuDao.getOneByEntity(new Menu().setName(name));
        }
        return resource;
    }

}
