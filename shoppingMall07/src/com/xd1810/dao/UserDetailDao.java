package com.xd1810.dao;

import com.xd1810.model.UserDetail;

import java.util.List;

public interface UserDetailDao {
    int addUserDetail(UserDetail userDetail);
    int delUserDetail(UserDetail userDetail);
    int updateUserDetail(UserDetail userDetail);
    List<UserDetail> getUserDetailByUid(Integer uid);
    UserDetail getUserDetailById(Integer id);
}
