package com.techsen.tsweb.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavController {

    @RequestMapping("/{module}")
    public String module(@PathVariable String module, Model model) {
        return module + "/" + module;
    }
    
}
