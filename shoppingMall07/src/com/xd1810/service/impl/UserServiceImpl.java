package com.xd1810.service.impl;

import com.xd1810.dao.UserDao;
import com.xd1810.model.User;
import com.xd1810.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public boolean register(User user) {
        if(user == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        List<User> list = userDao.getUserByName(user.getName());
        if(list == null||list.size() == 0){
            row = userDao.addUser(user);
            if(row != 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public User login(String name, String pass) {
        if(name == null||pass == null){
            throw new IllegalArgumentException("入参不合法");
        }
        List<User> list = userDao.getUserByNameAndPass(name,pass);
        if(list != null&&list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public User getUserByNameAndPass(String name, String pass) {
        if(name == null||pass == null){
            throw new IllegalArgumentException("入参不合法");
        }
        List<User> list = userDao.getUserByNameAndPass(name,pass);
        if(list != null&&list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public User getUserByName(String name) {
        if(name == null){
            throw new IllegalArgumentException("入参不合法");
        }
        List<User> list = userDao.getUserByName(name);
        if(list != null&&list.size() != 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        if(id == null){
            throw new IllegalArgumentException("入参不合法");
        }
       return userDao.getUserById(id);
    }

    @Override
    public boolean updateUser(User user) {
        if(user == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        row = userDao.updateUser(user);
        if(row != 0){
            return true;
        }
        return false;
    }
}
