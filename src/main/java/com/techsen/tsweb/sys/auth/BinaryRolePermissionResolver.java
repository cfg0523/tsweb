package com.techsen.tsweb.sys.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.springframework.stereotype.Component;

import com.techsen.tsweb.core.util.ValidUtil;
import com.techsen.tsweb.sys.domain.Auth;
import com.techsen.tsweb.sys.service.AuthService;

@Component("binaryRolePermissionResolver")
public class BinaryRolePermissionResolver implements RolePermissionResolver  {
    
    @Resource
    private AuthService authService;
    
    @Override
    public Collection<Permission> resolvePermissionsInRole(String roleName) {
        List<Auth> auths = this.authService.getAuthsByRoleName(roleName);
        if (ValidUtil.isValid(auths)) {
            List<Permission> perms = new ArrayList<Permission>(auths.size());
            for (Auth auth : auths) {
                perms.add(auth.binaryPermission());
            }
        }
        return null;
    }

}
