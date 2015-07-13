package com.techsen.tsweb.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techsen.tsweb.sys.domain.Menu;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.MenuService;
import com.techsen.tsweb.sys.service.UserService;

@Controller
public class UserController {

    @Resource
    private UserService userService;
    
    @Resource
    private MenuService menuService;

    @RequestMapping("/sys/user")
    public String list(Model model) {

        List<User> users = this.userService.findAll();
        model.addAttribute("users", users);

        return "sys/user-list";
    }

    @RequestMapping(value = "/sys/user/add", method = RequestMethod.GET)
    public String add(Model model) {
        List<Menu> menus = this.menuService.findAll();
        model.addAttribute("menus", menus);
        return "sys/user-add";
    }
    
    @RequestMapping(value = "/sys/user/add", method = RequestMethod.POST)
    public String add(User user, Model model) {
        this.userService.add(user);
        return "redirect:/sys/user";
    }
}
