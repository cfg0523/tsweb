package com.techsen.tsweb.sys.domain;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.sys.auth.Principal;

public class Auth extends BaseEntity<Auth> {

    private static final long serialVersionUID = 1651997840821737066L;

    private Principal principal;
    private String group;
    private int code;

    public Principal getPrincipal() {
        return principal;
    }

    public Auth setPrincipal(Principal principal) {
        this.principal = principal;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public Auth setGroup(String group) {
        this.group = group;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Auth setCode(int code) {
        this.code = code;
        return this;
    }

}
