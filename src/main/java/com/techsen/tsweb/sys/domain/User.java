package com.techsen.tsweb.sys.domain;

import com.techsen.tsweb.core.domain.BaseEntity;

public class User extends BaseEntity<User> {

    private static final long serialVersionUID = -6378136187265089253L;

    private String username;
    private String password;

    private Menu indexMenu;

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

}
