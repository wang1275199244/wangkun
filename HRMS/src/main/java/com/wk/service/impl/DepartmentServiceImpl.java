package com.wk.service.impl;

import com.wk.dao.DepartmentDao;
import com.wk.model.Department;
import com.wk.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    public boolean addDepartment(Department department) {
        if(department == null){
            return false;
        }
        int row = departmentDao.addDepartment(department);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean delDepartment(Department department) {
        if(department == null){
            return false;
        }
        int row = departmentDao.delDepartment(department);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean updateDepartment(Department department) {
        if(department == null){
            return false;
        }
        int row = departmentDao.updateDepartment(department);
        if(row != 0){
            return true;
        }
        return false;
    }

    public Department getDepartmentById(Integer id) {
        if(id == null||id == 0){
            return null;
        }
        return departmentDao.getDepartmentById(id);
    }

    public Department getDepartmentByName(String name) {
        if(name == null){
            return null;
        }
        return departmentDao.getDepartmentByName(name);
    }

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}
