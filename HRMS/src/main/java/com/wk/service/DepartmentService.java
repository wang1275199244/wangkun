package com.wk.service;

import com.wk.model.Department;

import java.util.List;

public interface DepartmentService {
    boolean addDepartment(Department department);
    boolean delDepartment(Department department);
    boolean updateDepartment(Department department);
    Department getDepartmentById(Integer id);
    Department getDepartmentByName(String name);
    List<Department> getAllDepartments();
}
