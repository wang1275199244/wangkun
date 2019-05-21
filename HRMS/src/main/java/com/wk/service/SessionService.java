package com.wk.service;

import com.wk.model.Session;
import java.util.List;

public interface SessionService {
    boolean addSession(Session session);
    boolean delSession(Session session);
    List<Session> getSessionByTrid(Integer trid);
    List<Session> getSessionByEmpid(Integer empid);
}
