package com.techsen.tsweb.sys.auth;

import org.apache.shiro.authz.Permission;

public class BinaryPermission implements Permission {

    private String type = BinaryPermissionResolver.WILDCARD_TOKEN; // 资源类型
    private String group = BinaryPermissionResolver.WILDCARD_TOKEN; // 资源组名
    private int code = BinaryPermissionResolver.NONE_PERMISSION_TOKEN; // 权限码

    public BinaryPermission() {
    }

    public BinaryPermission(String type, String group, int code) {
        this.type = type;
        this.group = group;
        this.code = code;
    }

    public String toString() {
        return type + BinaryPermissionResolver.PART_DIVIDER_TOKEN + group
                + BinaryPermissionResolver.PART_DIVIDER_TOKEN + code;
    }

    @Override
    public boolean implies(Permission p) {
        if (p instanceof BinaryPermission) {
            BinaryPermission other = (BinaryPermission) p;
            if (BinaryPermissionResolver.WILDCARD_TOKEN.equals(this.type)
                    || this.type.equalsIgnoreCase(other.type)) {
                if (BinaryPermissionResolver.WILDCARD_TOKEN.equals(this.group)
                        || this.group.equalsIgnoreCase(other.group)) {
                    return (this.code & other.code) > 0;
                }
            }
        }
        return false;
    }

    public String getType() {
        return type;
    }

    public BinaryPermission setType(String type) {
        this.type = type;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public BinaryPermission setGroup(String group) {
        this.group = group;
        return this;
    }

    public int getCode() {
        return code;
    }

    public BinaryPermission setCode(int code) {
        this.code = code;
        return this;
    }

}
