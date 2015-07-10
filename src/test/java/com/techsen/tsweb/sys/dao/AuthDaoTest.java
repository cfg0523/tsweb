package com.techsen.tsweb.sys.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.Auth;
import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-*.xml")
public class AuthDaoTest {

    @Resource
    private AuthDao authDao;
    
    @Test
    public void testGet() {
        Auth auth = this.authDao.get("A22");
        System.out.println(auth);
    }
    
    @Test
    public void testGetByEntity() {
        List<Auth> auths = this.authDao.getListByEntity(new Auth().setPrincipal(new Role().setId("R01")));
        for (Auth auth : auths) {
            System.out.println(auth.getId() + ":" + auth.getPrincipal() + ":" + auth.getPrincipal().getPrincipalId());
        }
    }
    
    @Test
    public void testFindAll() {
        List<Auth> auths = this.authDao.findAll();
        for (Auth auth : auths) {
            System.out.println(auth.getId() + ":" + auth.getPrincipal() + ":" + auth.getPrincipal().getPrincipalId());
        }
    }
    
    @Test
    public void testAddUpdateDelete() {
        Auth auth = new Auth().setId("Atest").setGroup("test").setCode(0xff).setPrincipal(new User().setId("U01"));
        this.authDao.add(auth);
        
        auth.setPrincipal(new Role().setId("R02"));
        this.authDao.update(auth);
        
        this.authDao.delete(auth);
    }
    
    @Test
    public void testGetAuthsByUserId() {
        List<Auth> auths = this.authDao.getAuthsByUserId("U01");
        for (Auth auth : auths) {
            System.out.println(auth.getId() + ":" + auth.getPrincipal() + ":" + auth.getPrincipal().getPrincipalId());
        }
    }
    
    @Test
    public void testGetAuthsByRoleId() {
        List<Auth> auths = this.authDao.getAuthsByRoleId("R01");
        for (Auth auth : auths) {
            System.out.println(auth.getId() + ":" + auth.getPrincipal() + ":" + auth.getPrincipal().getPrincipalId());
        }
    }
    
}
