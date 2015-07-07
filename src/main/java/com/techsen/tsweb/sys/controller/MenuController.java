package com.techsen.tsweb.sys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techsen.tsweb.sys.domain.Menu;
import com.techsen.tsweb.sys.domain.MenuType;
import com.techsen.tsweb.sys.service.MenuService;

@Controller
public class MenuController {

    @Resource
    private MenuService menuService;
    
    @RequestMapping("/")
    public String main(Model model) {
        
        Menu brand = this.menuService.getByEntity(new Menu().setType(MenuType.BRAND));
        model.addAttribute("brand", brand);
        
        return "sys/main";
    }
    
    @RequestMapping("/{module}")
    public String sys(@PathVariable String module, Model model) {
        Menu brand = this.menuService.getByEntity(new Menu().setType(MenuType.BRAND));
        model.addAttribute("brand", brand);
        
        Menu moduleMenu = this.menuService.getByEntity(new Menu().setName(module).setType(null));
        model.addAttribute("module", moduleMenu);
        return "sys/main";
    }
    
}
