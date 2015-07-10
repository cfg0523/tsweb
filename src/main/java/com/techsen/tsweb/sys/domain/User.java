package com.techsen.tsweb.sys.domain;

import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.sys.auth.Principal;
import com.techsen.tsweb.sys.auth.PrincipalType;

public class User extends BaseEntity<User> implements Principal {

    private static final long serialVersionUID = -6378136187265089253L;

    private String username;
    private String password;

    private Menu indexMenu;
    
    private List<UserRole> userRoles;

    @Override
    public PrincipalType getPrincipalType() {
        return PrincipalType.User;
    }

    @Override
    public String getPrincipalId() {
        return this.id;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Menu getIndexMenu() {
        return indexMenu;
    }

    public User setIndexMenu(Menu indexMenu) {
        this.indexMenu = indexMenu;
        return this;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public User setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

}
