package com.xd1810.dao;

import com.xd1810.model.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserDao {
    List<User> getUserByName(String name);
    List<User> getUserByNameAndPass(String name, String pass);
    int addUser(User user);
    User getUserById(Integer id);
    int updateUser(User user);
}
