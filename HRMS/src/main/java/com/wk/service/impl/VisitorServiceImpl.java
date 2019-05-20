package com.wk.service.impl;

import com.wk.dao.VisitorDao;
import com.wk.model.Visitor;
import com.wk.service.VisitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("visitorService")
public class VisitorServiceImpl implements VisitorService {
    @Resource
    private VisitorDao visitorDao;

    public Visitor getVisitorByName(String name) {
        if(name == null) {
            return null;
        }
        return visitorDao.getVisitorByName(name);
    }

    public Visitor VisitorLogin(Visitor visitor) {
        if(visitor ==null){
            return null;
        }
        return visitorDao.getVisitor(visitor);
    }

    public Visitor getVisitorById(Integer id) {
        if(id == null||id == 0){
            return null;
        }
        return visitorDao.getVisitorById(id);
    }

    public boolean register(Visitor visitor) {
        if(visitor ==null){
            return false;
        }
        int row = visitorDao.addVisitor(visitor);
        if(row != 0){
            return true;
        }
        return false;
    }
}
