package com.wk.service.impl;

import com.wk.dao.EmployeeDao;
import com.wk.model.Employee;
import com.wk.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;

    public Employee employeeLogin(Employee employee) {
        if(employee == null) {
            return null;
        }
        return employeeDao.getEmployee(employee);
    }

    public boolean addEmployee(Employee employee) {
        if(employee == null) {
            return false;
        }
        int row = employeeDao.addEmployee(employee);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean delEmployee(Employee employee) {
        if(employee == null) {
            return false;
        }
        int row = employeeDao.delEmployee(employee);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean updateEmployee(Employee employee) {
        if(employee == null) {
            return false;
        }
        int row = employeeDao.updateEmployee(employee);
        if(row != 0){
            return true;
        }
        return false;
    }

    public List<Employee> getEmployeeByPid(Integer pid) {
        if(pid == null||pid == 0){
            return null;
        }
        return employeeDao.getEmployeeByPid(pid);
    }

    public List<Employee> getEmployeeByDepid(Integer depid) {
        if(depid == null||depid == 0){
            return null;
        }
        return employeeDao.getEmployeeByPid(depid);
    }
}
