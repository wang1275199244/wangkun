package com.wk.controller;

import com.wk.model.*;
import com.wk.service.*;
import com.wk.utils.GetTotalPage;
import com.wk.utils.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;
    @Resource
    private SessionService sessionService;
    @Resource
    private TrainService trainService;

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

    @RequestMapping("toEmployeeInformation")
    protected String toEmployeeInformation()throws Exception {
        return "employeeInformation";

    }

    @RequestMapping("toShowAddressList")
    protected String toShowAddressList(HttpServletResponse response,HttpSession session)throws Exception{
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
    @RequestMapping("getEmploy")
    @ResponseBody
    protected List<Employee> getEmploy(Integer pid1, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        if(pid1 != null&&pid1 != 0){
            return employeeService.getEmployeeByPid(pid1);
        }
        return null;
    }

    //获得培训信息
    @RequestMapping("toShowMyTrain")
    protected String toShowMyTrain(@RequestParam(name = "currentPage", required = false) Integer currentPage, HttpServletResponse response, HttpSession session)throws Exception{
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee != null){
            List<Session> sessions = sessionService.getSessionByEmpid(employee.getId());
            List<Train> trains = new ArrayList<Train>();
            if(sessions != null&&sessions.size() != 0){
                for (Session session1 : sessions) {
                    Train train = trainService.getTrainById(session1.getTrid());
                    if(train != null&&train.getState() == 1){
                        trains.add(train);
                    }
                }
            }
            int cp = 0;
            int pageSize = 8;
            if (currentPage != null) {
                cp = currentPage;
            } else {
                cp = 1;

            }
            if (trains != null&&trains.size() != 0) {
                int totalRows = trains.size();
                int totalPage = GetTotalPage.getTp(totalRows);
                List<List<Train>> list1 = HibernateUtil.split(Train.class, trains, pageSize);
                List<Train> trains2 = HibernateUtil.getSplit(Train.class, list1, cp);
                session.setAttribute("ts1", trains2);
                session.setAttribute("tp", totalPage);
            } else {
                List<Train> trains2 = new ArrayList<Train>();
                session.setAttribute("ts1", trains2);
                session.setAttribute("tp", 1);

            }
        }

        return "showMyTrain";
    }

    //确认培训
    @RequestMapping("confirmTrain")
    protected String confirmTrain(@RequestParam(name = "id", required = false) Integer id, HttpServletResponse response, HttpSession session)throws Exception{
        if(id != null&&id != 0) {
            Train train = trainService.getTrainById(id);
            if(train != null){
                train.setState(2);
                trainService.updateTrain(train);
            }
        }
        return "forward:toShowMyTrain";
    }
}
