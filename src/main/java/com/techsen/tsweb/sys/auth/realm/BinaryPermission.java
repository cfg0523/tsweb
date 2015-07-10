package com.techsen.tsweb.sys.auth.realm;

import static com.techsen.tsweb.core.util.Const.EMPTY_STRING;

import org.apache.shiro.authz.Permission;

public class BinaryPermission implements Permission {
    
    private String group = EMPTY_STRING; //权限组名
    private int code = 0x0; //权限码
    
    public BinaryPermission() {
    }
    
    public BinaryPermission(String group, int code) {
        this.group = group;
        this.code = code;
    }
    
    public String toString() {
        return group + BinaryPermissionResolver.PART_DIVIDER_TOKEN
                + BinaryPermissionResolver.PART_DIVIDER_TOKEN + code;
    }
    
    @Override
    public boolean implies(Permission p) {
        if (p instanceof BinaryPermission) {
            BinaryPermission other = (BinaryPermission) p;
            if (this.group.equals("*")) {
                return (this.code & other.getCode()) > 0;
            } else {
                if (this.group.equals(other.getGroup())) {
                    return (this.code & other.getCode()) > 0;
                }
            }
        }
        return false;
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

    public static void main(String[] args) {
        BinaryPermission a = new BinaryPermission("*", 0x2);
        BinaryPermission b = new BinaryPermission("sys", 0x2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a.implies(b));
        System.out.println(b.implies(a));
    }
    
}

