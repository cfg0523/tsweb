package com.techsen.tsweb.sys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techsen.tsweb.sys.service.MenuService;

@Controller
public class MenuController {

    @Resource
    private MenuService menuService;
    
    @RequestMapping("/")
    public String main(Model model) {
        return "main";
    }
    
    @RequestMapping("/{module}")
    public String module(@PathVariable String module, Model model) {
        return module + "/" + module;
    }
    
}
