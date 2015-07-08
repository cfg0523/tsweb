package com.techsen.tsweb.sys.auth.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.domain.UserRole;
import com.techsen.tsweb.sys.service.UserService;
import com.techsen.tsweb.sys.util.SysConst;

@Component("localRealm")
public class LocalRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo (
            PrincipalCollection principals) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute(SysConst.LOGIN_USER);
        for (UserRole userRole : user.getUserRoles()) {
            Role role = userRole.getRole();
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo (
            AuthenticationToken token) throws AuthenticationException {
        if (token instanceof UsernamePasswordToken) {
            UsernamePasswordToken upt = (UsernamePasswordToken) token;
            String username = upt.getUsername();
            String password = String.valueOf(upt.getPassword());
            
            User user = this.userService.getByEntity(new User().setUsername(username).setPassword(password));
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
