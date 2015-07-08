package com.techsen.tsweb.sys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.UserService;

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
    public String login(User user) {
        user = this.userService.getByEntity(user);
        if (user != null) {
            return "redirect:" + user.getIndexMenu().getPath();
        }
        return "login";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }

}
