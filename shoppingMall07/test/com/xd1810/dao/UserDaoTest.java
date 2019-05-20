package com.xd1810.dao;

import com.xd1810.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Test
    public void testGetUserByNameAndPass() {
        List<User> users = userDao.getUserByNameAndPass("w12345", "adwx56");
        System.out.println(users);
    }

}
