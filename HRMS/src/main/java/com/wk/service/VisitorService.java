package com.wk.service;

import com.wk.model.Visitor;

public interface VisitorService {
    Visitor getVisitorByName(String name);
    Visitor VisitorLogin(Visitor visitor);
    Visitor getVisitorById(Integer id);
    boolean register(Visitor visitor);
}
