package com.wk.dao;

import com.wk.model.Visitor;

public interface VisitorDao {
    Visitor getVisitorByName(String name);
    Visitor getVisitor(Visitor visitor);
    Visitor getVisitorById(Integer id);
    int addVisitor(Visitor visitor);

}
