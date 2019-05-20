package com.xd1810.service;

import com.xd1810.model.User;

public interface UserService {
    boolean register(User user);
    User login(String name, String pass);
    User getUserByNameAndPass(String name, String pass);
    User getUserByName(String name);
    User getUserById(Integer id);
    boolean updateUser(User user);
}
