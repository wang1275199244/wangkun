package com.wk.service.impl;

import com.wk.dao.AdminDao;
import com.wk.model.Admin;
import com.wk.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    public Admin adminLogin(Admin admin) {
        if(admin == null) {
            return null;
        }
        return adminDao.getAdmin(admin);
    }
}
