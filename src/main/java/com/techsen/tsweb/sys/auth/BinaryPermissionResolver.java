package com.techsen.tsweb.sys.auth;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.springframework.stereotype.Component;

import com.techsen.tsweb.core.util.ValidUtil;
import com.techsen.tsweb.sys.service.ResourceService;

@Component("binaryPermissionResolver")
public class BinaryPermissionResolver implements PermissionResolver {

    @javax.annotation.Resource
    private ResourceService resourceService;
    
    /**
     * 模式 1： 权限类型:权限组名:权限码
     *    例：menu:sys:0xf, controller:sys:0xf
     *    例：menu::0xf = menu:*:0xf
     * 模式 2： 权限类型:权限组名:资源名或操作名
     *    例：menu:sys:user, controller:sys:adduser
     */

    protected static final String WILDCARD_TOKEN = "*";
    protected static final String PART_DIVIDER_TOKEN = ":";
    protected static final int ALL_PERMISSION_TOKEN = 0xFFFFFFFF;
    protected static final int NONE_PERMISSION_TOKEN = 0x0;
    
    @Override
    public Permission resolvePermission(String permissionString) {
        BinaryPermission bp = new BinaryPermission();
        if (ValidUtil.isValid(permissionString)) {
            String[] arr = permissionString.split(PART_DIVIDER_TOKEN);
            if (arr.length >= 3) {
                bp.setType(arr[0]);
                bp.setGroup(arr[1]);
                int code = 0x0;
                try {
                    code = Integer.valueOf(arr[2]);
                } catch (Exception ne) {
                    try {
                        ResourceType type = ResourceType.valueOf(arr[0]);
                        Resource resource = this.resourceService.getResourceByTypeAndName(type, arr[2]);
                        code = resource.getAuthCode();
                    } catch (Exception ce) {}
                }
                bp.setCode(code);
            } else if (arr.length >= 2) {
                bp.setType(arr[0]);
                bp.setGroup(arr[1]);
                bp.setCode(ALL_PERMISSION_TOKEN);
            } else if (arr.length >= 1) {
                bp.setType(arr[0]);
                bp.setGroup(WILDCARD_TOKEN);
                bp.setCode(ALL_PERMISSION_TOKEN);
            }
        }
        return bp;
    }

}
