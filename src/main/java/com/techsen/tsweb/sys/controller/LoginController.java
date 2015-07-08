package com.techsen.tsweb.sys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.UserService;
import com.techsen.tsweb.sys.util.SysConst;

@Controller
@RequestMapping("/")
public class LoginController {

    @Resource
    private UserService userService;
    
    @RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
    public String main() {
        return "login";
    }

    @RequestMapping(value = { "/", "/login" }, method = RequestMethod.POST)
    public String login(User user, boolean rememberMe) {
        Subject subject = SecurityUtils.getSubject();
        
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(rememberMe);
        subject.login(token);
        
        user = (User) subject.getSession().getAttribute(SysConst.LOGIN_USER);
        return "redirect:" + user.getIndexMenu().getPath();
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        SecurityUtils.getSubject().logout();
        return "login";
    }

}
