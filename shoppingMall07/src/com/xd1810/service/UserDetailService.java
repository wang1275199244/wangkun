package com.xd1810.service;


import com.xd1810.model.UserDetail;

import java.util.List;

public interface UserDetailService {
    List<UserDetail> getUserDetailByUid(Integer uid);
    boolean addUserDetail(UserDetail userDetail);
    boolean updateUserDetail(UserDetail userDetail);
    boolean delUserDetail(Integer id);
    UserDetail getUserDetailById(Integer id);
}
