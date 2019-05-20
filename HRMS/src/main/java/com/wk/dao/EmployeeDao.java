package com.wk.dao;

import com.wk.model.Employee;

import java.util.List;

public interface EmployeeDao {
    int addEmployee(Employee employee);
    int delEmployee(Employee employee);
    int updateEmployee(Employee employee);
    Employee getEmployee(Employee employee);
    List<Employee> getEmployeeByPid(Integer pid);
    List<Employee> getEmployeeByDepid(Integer depid);
    Employee getEmployeeById(Integer id);
}
