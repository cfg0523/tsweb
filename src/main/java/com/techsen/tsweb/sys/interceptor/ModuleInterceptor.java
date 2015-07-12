package com.techsen.tsweb.sys.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.techsen.tsweb.sys.domain.Menu;
import com.techsen.tsweb.sys.service.MenuService;

public class ModuleInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private MenuService menuService;
    
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        
        String servletPath = request.getServletPath();
        
        System.out.println("------------------");
        System.out.println(servletPath);
        System.out.println("------------------");
        
        String[] strs = servletPath.split("/");
        if (strs.length >= 2) {
            String module = strs[1];
            Menu moduleMenu = this.menuService.getOneByEntity(new Menu().setName(module));
            System.out.println("--------------------");
            System.out.println("module: " + module);
            System.out.println("moduleMenu: " + moduleMenu.getName());
            System.out.println("--------------------");
            modelAndView.getModel().put("moduleMenu", moduleMenu);
        }
        
        Menu brandMenu = this.menuService.getOneByEntity(new Menu().setResourceGroup("root"));
        modelAndView.getModel().put("brandMenu", brandMenu);
        
        super.postHandle(request, response, handler, modelAndView);
    }
    
}
