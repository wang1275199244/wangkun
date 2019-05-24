package com.wk.service;

import com.wk.model.Salary;

import java.util.List;

public interface SalaryService {
    boolean addSalary(Salary salary);
    boolean updateSalary(Salary salary);
    Salary getSalaryById(Integer id);
    List<Salary> getSalaryByEmpid(Integer empid);
    List<Salary> getSalary(Salary salary);
}
