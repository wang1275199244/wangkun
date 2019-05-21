package com.wk.dao;

import com.wk.model.Session;

import java.util.List;

public interface SessionDao {
    int addSession(Session session);
    int delSession(Session session);
    List<Session> getSessionByTrid(Integer trid);
    List<Session> getSessionByEmpid(Integer empid);

}
