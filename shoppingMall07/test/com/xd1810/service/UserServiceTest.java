package com.xd1810.service;

import com.xd1810.model.User;
import org.junit.Test;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void testGetUserByNameAndPass() {
        User user = userService.login("w12345", "adwx56");
        System.out.println(userService);
    }

}
