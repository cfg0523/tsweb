package com.techsen.tsweb.sys.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.sys.domain.Role;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.domain.UserRole;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-*.xml")
public class UserRoleDaoTest {

    @Resource
    private UserRoleDao userRoleDao;
    
    @Test
    public void testGet() {
        UserRole userRole = this.userRoleDao.get("UR01");
        List<UserRole> userRoles = this.userRoleDao.findAll();
        UserRole ur = this.userRoleDao.getByEntity(new UserRole().setUser(new User().setId("U01")).setRole(new Role().setId("R01")));
    }
    
}
