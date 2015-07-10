package com.techsen.tsweb.sys.auth.realm;

import java.util.Collection;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.springframework.stereotype.Component;

@Component("binaryRolePermissionResolver")
public class BinaryRolePermissionResolver implements RolePermissionResolver  {
    
    @Override
    public Collection<Permission> resolvePermissionsInRole(String roleString) {
        return null;
    }

}
