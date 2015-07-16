package com.techsen.tsweb.sys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techsen.tsweb.core.util.sql.Pager;
import com.techsen.tsweb.sys.domain.Menu;
import com.techsen.tsweb.sys.service.MenuService;

@Controller
public class MenuController {

    @Resource
    private MenuService menuService;
    
    @RequestMapping("/sys/menu")
    public String list(Pager<Menu> pager, Model model) {
        pager = this.menuService.findByPager(pager);
        model.addAttribute("menus", pager.getEntities());
        model.addAttribute("pager", pager);
        return "sys/menu-list";
    }
    
    @RequestMapping(value="/sys/menu/add", method = RequestMethod.GET)
    public String add(Model model) {
        return "sys/menu-add";
    }
    
    @RequestMapping(value = "/sys/menu/add", method = RequestMethod.POST)
    public String add(Menu menu) {
        this.menuService.add(menu);
        return "redirect:/sys/menu";
    }
    
    @RequestMapping(value="/sys/menu/update/{menuId}", method=RequestMethod.GET)
    public String update(@PathVariable String menuId, Model model) {
        Menu menu = this.menuService.get(menuId);
        model.addAttribute("menu", menu);
        return "sys/menu-update";
    }
    
    @RequestMapping(value = "/sys/menu/update", method = RequestMethod.POST)
    public String update(Menu menu) {
        this.menuService.update(menu);
        return "redirect:/sys/menu";
    }
    
    @RequestMapping("/sys/menu/delete/{menuId}")
    public String delete(@PathVariable String menuId) {
        this.menuService.delete(new Menu().setId(menuId));
        return "redirect:/sys/menu";
    }
    
}
