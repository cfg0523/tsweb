package com.techsen.tsweb.sys.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-*.xml")
public class MenuDaoTest {

    @Resource
    private MenuDao menuDao;

    @Test
    public void testGet() {
        Menu menu = this.menuDao.get("M01");
        Menu parent = menu.getParent();
        List<Menu> subMenus = menu.getSubMenus();

        System.out.println(menu.getName());
        System.out.println(parent.getName());
        System.out.println(subMenus.size());
    }

    @Test
    public void testAddUpdateDelete() {
        Menu menu = new Menu().setId("MT01");
        menu.setName("test").setPath("/test");
        this.menuDao.add(menu);

        menu.setLabel("TEST").setAuthName("test");
        menu.setCreateBy("U01").setCreateDate(new Date());
        menu.setUpdateBy("U01").setUpdateDate(new Date());
        menu.setRemark("TEST REMARK");
        this.menuDao.update(menu);

        this.menuDao.delete(menu);
    }

    @Test
    public void testFindAll() {
        List<Menu> menus = this.menuDao.findAll();
        System.out.println(menus);
    }
    
}
