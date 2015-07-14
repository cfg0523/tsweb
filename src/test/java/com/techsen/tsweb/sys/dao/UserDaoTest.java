package com.techsen.tsweb.sys.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.core.util.sql.Operator;
import com.techsen.tsweb.core.util.sql.Phrase;
import com.techsen.tsweb.core.util.sql.Relation;
import com.techsen.tsweb.core.util.sql.Pager;
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
    
    @Test
    public void testGetSql() {
        Pager<User> sql = new Pager<User>();
        sql.appendPhrases(new Phrase(Relation.and, "user_name", Operator.like, "a"));
        sql.appendPhrases(new Phrase(Relation.and, "user_id", Operator.gt, "U02"));
        sql.setPagesize(10).setPagecode(1);
        
        List<User> users = this.userDao.findBySql(sql);
        int totalsize = this.userDao.getTotalSize();
        
        System.out.println(users);
        System.out.println(totalsize);
    }
}
