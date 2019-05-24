package com.wk.service.impl;

import com.wk.dao.SalaryDao;
import com.wk.model.Salary;
import com.wk.service.SalaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {
    @Resource
    private SalaryDao salaryDao;

    public boolean addSalary(Salary salary) {
        if(salary == null){
            return false;
        }
        int row = salaryDao.addSalary(salary);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean updateSalary(Salary salary) {
        if(salary == null){
            return false;
        }
        int row = salaryDao.updateSalary(salary);
        if(row != 0){
            return true;
        }
        return false;
    }

    public Salary getSalaryById(Integer id) {
        if(id == null||id == 0){
            return null;
        }
        return salaryDao.getSalaryById(id);
    }

    public List<Salary> getSalaryByEmpid(Integer empid) {
        if(empid == null||empid == 0){
            return null;
        }
        return salaryDao.getSalaryByEmpid(empid);
    }

    public List<Salary> getSalary(Salary salary) {
        if(salary == null){
            return null;
        }
        return salaryDao.getSalary(salary);
    }
}
