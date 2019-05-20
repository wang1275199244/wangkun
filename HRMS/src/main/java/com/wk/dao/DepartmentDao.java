package com.wk.dao;

import com.wk.model.Department;

import java.util.List;

public interface DepartmentDao {
    int addDepartment(Department department);
    int delDepartment(Department department);
    int updateDepartment(Department department);
    Department getDepartmentById(Integer id);
    Department getDepartmentByName(String name);
    List<Department> getAllDepartments();
}
