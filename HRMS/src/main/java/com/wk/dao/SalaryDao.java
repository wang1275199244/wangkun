package com.wk.dao;

import com.wk.model.Salary;

import java.util.List;

public interface SalaryDao {
    int addSalary(Salary salary);
    int updateSalary(Salary salary);
    Salary getSalaryById(Integer id);
    List<Salary> getSalaryByEmpid(Integer empid);
    List<Salary> getSalary(Salary salary);
}
