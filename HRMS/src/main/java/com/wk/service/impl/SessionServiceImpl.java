package com.wk.service.impl;

import com.wk.dao.SessionDao;
import com.wk.model.Session;
import com.wk.service.SessionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sessionService")
public class SessionServiceImpl implements SessionService {
    @Resource
    private SessionDao sessionDao;

    public boolean addSession(Session session) {
        if(session == null){
            return false;
        }
        int row = sessionDao.addSession(session);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean delSession(Session session) {
        if(session == null){
            return false;
        }
        int row = sessionDao.delSession(session);
        if(row != 0){
            return true;
        }
        return false;
    }

    public List<Session> getSessionByTrid(Integer trid) {
        if(trid != null&&trid != 0){
            return null;
        }
        return sessionDao.getSessionByTrid(trid);
    }

    public List<Session> getSessionByEmpid(Integer empid) {
        if(empid != null&&empid != 0){
            return null;
        }
        return sessionDao.getSessionByEmpid(empid);
    }
}
