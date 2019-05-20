package com.xd1810.service.impl;

import com.xd1810.dao.UserDetailDao;
import com.xd1810.model.UserDetail;
import com.xd1810.service.UserDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailService {
    @Resource
    private UserDetailDao userDetailDao;

    @Override
    public List<UserDetail> getUserDetailByUid(Integer uid) {
        if (uid == null||uid == 0){
            return null;
        }
        return userDetailDao.getUserDetailByUid(uid);
    }

    @Override
    public boolean addUserDetail(UserDetail userDetail) {
        if(userDetail == null){
            throw new IllegalArgumentException("入参不合法");
        }
        int row = 0;
        row = userDetailDao.addUserDetail(userDetail);
        if(row != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUserDetail(UserDetail userDetail) {
        if (userDetail == null){
            return false;
        }
        int row = 0;
        row = userDetailDao.updateUserDetail(userDetail);
        if(row != 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delUserDetail(Integer id) {
        if (id == null||id == 0){
            return false;
        }
        UserDetail userDetail = userDetailDao.getUserDetailById(id);

        if(userDetail != null){
            int row = 0;
            row = userDetailDao.delUserDetail(userDetail);
            if(row != 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public UserDetail getUserDetailById(Integer id) {
        if(id == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return userDetailDao.getUserDetailById(id);

    }
}
