package com.techsen.tsweb.sys.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-*.xml")
public class UserDaoTest {

    @Resource
    private UserDao userDao;
    
    @Test
    public void testGet() {
        User user = this.userDao.get("U01");
        
        System.out.println(user);
    }
    
}
