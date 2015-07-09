package com.techsen.tsweb.sys.domain;

import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;

public class Role extends BaseEntity<Role> {

    private static final long serialVersionUID = -6627118770868694695L;

    private String name;
    private String label;
    
    private List<UserRole> userRoles;

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Role setLabel(String label) {
        this.label = label;
        return this;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public Role setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

}
