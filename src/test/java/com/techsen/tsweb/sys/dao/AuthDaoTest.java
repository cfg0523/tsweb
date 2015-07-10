package com.techsen.tsweb.sys.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.auth.PrincipalType;
import com.techsen.tsweb.sys.auth.ResourceType;
import com.techsen.tsweb.sys.domain.Auth;

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
        List<Auth> auths = this.authDao.getListByEntity(new Auth().setPrincipalType(PrincipalType.Role).setPrincipalId("R01"));
        for (Auth auth : auths) {
            System.out.println(auth.getId() + ":" + auth.getPrincipalType() + ":" + auth.getPrincipalId());
        }
    }
    
    @Test
    public void testFindAll() {
        List<Auth> auths = this.authDao.findAll();
        for (Auth auth : auths) {
            System.out.println(auth.getId() + ":" + auth.getPrincipalType() + ":" + auth.getPrincipalId());
        }
    }
    
    @Test
    public void testAddUpdateDelete() {
        Auth auth = new Auth().setId("Atest")
                .setResourceType(ResourceType.Menu)
                .setResourceGroup("test")
                .setCode(0xff)
                .setPrincipalType(PrincipalType.User)
                .setPrincipalId("U01");
        this.authDao.add(auth);
        
        auth.setPrincipalType(PrincipalType.Role).setPrincipalId("R01");
        this.authDao.update(auth);
        
        this.authDao.delete(auth);
    }
    
    @Test
    public void testGetAuthsByUserId() {
        List<Auth> auths = this.authDao.getAuthsByUserId("U01");
        for (Auth auth : auths) {
            System.out.println(auth.getId() + ":" + auth.getPrincipalType() + ":" + auth.getPrincipalId());
        }
    }
    
    @Test
    public void testGetAuthsByRoleId() {
        List<Auth> auths = this.authDao.getAuthsByRoleId("R01");
        for (Auth auth : auths) {
            System.out.println(auth.getId() + ":" + auth.getPrincipalType() + ":" + auth.getPrincipalId());
        }
    }
    
}
