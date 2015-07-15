package com.techsen.tsweb.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techsen.tsweb.core.util.sql.Pager;
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
    public String list(Pager<User> pager, Model model) {
        pager = this.userService.findByPager(pager);
        model.addAttribute("users", pager.getEntities());
        model.addAttribute("pager", pager);
        
        return "sys/user-list";
    }
    
    @RequestMapping(value = "/sys/user/add", method = RequestMethod.GET)
    public String add(Model model) {
        List<Menu> menus = this.menuService.findAll();
        model.addAttribute("menus", menus);
        return "sys/user-add";
    }

    @RequestMapping(value = "/sys/user/add", method = RequestMethod.POST)
    public String add(User user) {
        this.userService.add(user);
        return "redirect:/sys/user";
    }

    @RequestMapping(value = "/sys/user/update/{userId}", method = RequestMethod.GET)
    public String update(@PathVariable String userId, Model model) {
        User user = this.userService.get(userId);
        List<Menu> menus = this.menuService.findAll();

        model.addAttribute("user", user);
        model.addAttribute("menus", menus);
        return "sys/user-update";
    }

    @RequestMapping(value = "/sys/user/update", method = RequestMethod.POST)
    public String update(User user) {
        this.userService.update(user);
        return "redirect:/sys/user";
    }

    @RequestMapping("/sys/user/delete/{userId}")
    public String delete(@PathVariable String userId) {
        this.userService.delete(new User().setId(userId));
        return "redirect:/sys/user";
    }

    @RequestMapping(value = "/sys/user/chgpwd/{userId}", method = RequestMethod.GET)
    public String chgpwd(@PathVariable String userId, Model model) {
        User user = this.userService.get(userId);
        model.addAttribute("user", user);
        return "sys/user-chgpwd";
    }
    
    @RequestMapping(value = "/sys/user/chgpwd", method = RequestMethod.POST)
    public String chgpwd(User user) {
        this.userService.changePassword(user);
        return "redirect:/sys/user";
    }
    
}
