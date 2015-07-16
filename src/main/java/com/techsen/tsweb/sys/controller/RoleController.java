package com.techsen.tsweb.sys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techsen.tsweb.core.util.sql.Pager;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.service.RoleService;

@Controller
public class RoleController {

    @Resource
    private RoleService roleService;
    
    @RequestMapping("/sys/role")
    public String list(Pager<Role> pager, Model model) {
        pager = this.roleService.findByPager(pager);
        model.addAttribute("roles", pager.getEntities());
        model.addAttribute("pager", pager);
        return "sys/role-list";
    }
    
    @RequestMapping(value="/sys/role/add", method = RequestMethod.GET)
    public String add(Model model) {
        return "sys/role-add";
    }
    
    @RequestMapping(value = "/sys/role/add", method = RequestMethod.POST)
    public String add(Role role) {
        this.roleService.add(role);
        return "redirect:/sys/role";
    }
    
    @RequestMapping(value="/sys/role/update/{roleId}", method=RequestMethod.GET)
    public String update(@PathVariable String roleId, Model model) {
        Role role = this.roleService.get(roleId);
        model.addAttribute("role", role);
        return "sys/role-update";
    }
    
    @RequestMapping(value = "/sys/role/update", method = RequestMethod.POST)
    public String update(Role role) {
        this.roleService.update(role);
        return "redirect:/sys/role";
    }
    
    @RequestMapping("/sys/role/delete/{roleId}")
    public String delete(@PathVariable String roleId) {
        this.roleService.delete(new Role().setId(roleId));
        return "redirect:/sys/role";
    }
    
}
