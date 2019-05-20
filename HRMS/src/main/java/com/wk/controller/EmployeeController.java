package com.wk.controller;

import com.wk.model.Admin;
import com.wk.model.Department;
import com.wk.model.Employee;
import com.wk.model.Position;
import com.wk.service.AdminService;
import com.wk.service.DepartmentService;
import com.wk.service.EmployeeService;
import com.wk.service.PositionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;


    @RequestMapping("toEmployeeLogin")
    public String toEmployeeLogin()throws Exception{
        return "employeeLogin";
    }

    @RequestMapping("employeeLogin")
    protected String employeeLogin(Employee employee, HttpServletResponse response, HttpSession session)throws Exception {
        Employee employee1 = employeeService.employeeLogin(employee);
        if (employee1 != null) {
            session.setAttribute("employee", employee1);
            return "employeeInformation";
        } else {
            return "employeeLogin";
        }
    }

    @RequestMapping("toShowAddressList")
    public String toShowAddressList(HttpServletResponse response,HttpSession session)throws Exception{
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        List<Department> departments = departmentService.getAllDepartments();
        session.setAttribute("dts2",departments);
        return "showAddressList";
    }

    //获得职位
    @RequestMapping("getPositions1")
    @ResponseBody
    protected List<Position> getPositions1(Integer depid1, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        if(depid1 != null&&depid1 != 0){
            return positionService.getPositionByDepid(depid1);
        }
        return null;
    }

    //获得员工
    @RequestMapping("getEmployees1")
    @ResponseBody
    protected List<Employee> getEmployees1(Integer pid1, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        if(pid1 != null&&pid1 != 0){
            return employeeService.getEmployeeByPid(pid1);
        }
        return null;
    }
}
