package com.techsen.tsweb.sys.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.techsen.tsweb.core.util.sql.Operator;
import com.techsen.tsweb.core.util.sql.Pager;
import com.techsen.tsweb.core.util.sql.Phrase;
import com.techsen.tsweb.core.util.sql.Relation;
import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-*.xml")
public class UserServiceTest {
    
    @Resource
    private UserService userService;
    
    @Test
    public void testGetSql() {
        Pager<User> pager = new Pager<User>();
        pager.appendPhrases(new Phrase(Relation.and, "user_name", Operator.like, "a"));
        pager.appendPhrases(new Phrase(Relation.and, "user_id", Operator.gt, "U02"));
        pager.setPagesize(10).setPagecode(1);
        
        pager = this.userService.findByPager(pager);
        
        System.out.println(pager.getTotalsize());
        System.out.println(pager.getPagesize());
        System.out.println(pager.getPagecode());
        System.out.println(pager.getEntities());
    }
}
