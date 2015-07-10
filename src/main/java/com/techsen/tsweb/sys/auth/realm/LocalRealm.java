package com.techsen.tsweb.sys.auth.realm;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.techsen.tsweb.sys.domain.Auth;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.domain.UserRole;
import com.techsen.tsweb.sys.service.AuthService;
import com.techsen.tsweb.sys.service.UserRoleService;
import com.techsen.tsweb.sys.service.UserService;
import com.techsen.tsweb.sys.util.SysConst;

@Component("localRealm")
public class LocalRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    
    @Resource
    private UserRoleService userRoleService;
    
    @Resource
    private AuthService authService;
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo (
            PrincipalCollection principals) {
        SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo();
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(SysConst.LOGIN_USER);
        
        List<UserRole> userRoles = this.userRoleService.getUserRolesByUserId(user.getId());
        List<Role> roles = UserRole.getRolesFromUserRoleList(userRoles);
        for (Role role : roles) {
            sai.addRole(role.getName());
        }
        
        List<Auth> auths = this.authService.getAuthsByUserId(user.getId());
        for (Auth auth : auths) {
            sai.addObjectPermission(auth.binaryPermission());
        }
        
        return sai;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo (
            AuthenticationToken token) throws AuthenticationException {
        if (token instanceof UsernamePasswordToken) {
            UsernamePasswordToken upt = (UsernamePasswordToken) token;
            String username = upt.getUsername();
            String password = String.valueOf(upt.getPassword());
            
            User user = this.userService.getOneByEntity(new User().setUsername(username).setPassword(password));
            SecurityUtils.getSubject().getSession().setAttribute(SysConst.LOGIN_USER, user);
            
            if (user != null) {
                return new SimpleAuthenticationInfo(username, password, this.getName());
            } else {
                throw new UnknownAccountException("用户名和密码不正确");
            }
        }
        return null;
    }

}
