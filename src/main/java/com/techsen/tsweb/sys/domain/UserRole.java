package com.techsen.tsweb.sys.domain;

import java.util.ArrayList;
import java.util.List;

import com.techsen.tsweb.core.domain.BaseEntity;
import com.techsen.tsweb.core.util.ValidUtil;

public class UserRole extends BaseEntity<UserRole> {

    private static final long serialVersionUID = 5054914837898444376L;

    private User user;
    private Role role;

    public static List<User> getUsersFromUserRoleList(List<UserRole> userRoles) {
        if (ValidUtil.isValid(userRoles)) {
            List<User> users = new ArrayList<User>(userRoles.size());
            for (UserRole userRole : userRoles) {
                users.add(userRole.getUser());
            }
            return users;
        }
        return null;
    }

    public static List<Role> getRolesFromUserRoleList(List<UserRole> userRoles) {
        if (ValidUtil.isValid(userRoles)) {
            List<Role> roles = new ArrayList<Role>(userRoles.size());
            for (UserRole userRole : userRoles) {
                roles.add(userRole.getRole());
            }
            return roles;
        }
        return null;
    }
    
    public User getUser() {
        return user;
    }

    public UserRole setUser(User user) {
        this.user = user;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserRole setRole(Role role) {
        this.role = role;
        return this;
    }

}
