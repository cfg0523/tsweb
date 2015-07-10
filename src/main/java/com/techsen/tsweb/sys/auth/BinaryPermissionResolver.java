package com.techsen.tsweb.sys.auth;

import static com.techsen.tsweb.core.util.ExceptionUtil.throwRuntimeException;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.springframework.stereotype.Component;

import com.techsen.tsweb.core.util.ValidUtil;

@Component("binaryPermissionResolver")
public class BinaryPermissionResolver implements PermissionResolver {

    /**
     * 模式 1： 权限组名:权限位索引:权限码
     *    例：sys:1 = sys:1:0x2 = sys::0x2
     * 模式 2： 权限组名:资源类型:资源名
     *    例：sys:menu:user = sys:根据资源类型和资源名获取到的权限组内索引值
     *    如：sys:menu:user = sys:1 (user资源的权限组内索引值为1)
     */

    protected static final String WILDCARD_TOKEN = "*";
    protected static final String PART_DIVIDER_TOKEN = ":";
    
    @Override
    public Permission resolvePermission(String permissionString) {
        BinaryPermission bp = new BinaryPermission();
        if (ValidUtil.isValid(permissionString)) {
            if (permissionString.contains(PART_DIVIDER_TOKEN)) {
                String[] arr = permissionString.split(PART_DIVIDER_TOKEN);
                if (arr.length >= 3) {
                    bp.setGroup(arr[0]);
                    bp.setCode(Integer.valueOf(arr[2]));
                } else if (arr.length >= 2) {
                    bp.setGroup(arr[0]);
                    int index = Integer.valueOf(arr[1]);
                    if (index < 0 || index > 31) {
                        throwRuntimeException("权限位索引必须在0 ~ 31之间");
                    }
                    bp.setCode(1 << index);
                }
            } else {
                bp.setGroup(permissionString);
                bp.setCode(0xFFFFFFFF);
            }
        }
        return bp;
    }

}
