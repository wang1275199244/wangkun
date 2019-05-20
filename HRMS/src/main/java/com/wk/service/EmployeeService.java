package com.wk.service;

import com.wk.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee employeeLogin(Employee employee);
    boolean addEmployee(Employee employee);
    boolean delEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    List<Employee> getEmployeeByPid(Integer pid);
    List<Employee> getEmployeeByDepid(Integer depid);

}
