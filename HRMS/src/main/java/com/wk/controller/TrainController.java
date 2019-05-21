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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TrainController {
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private TrainService trainService;
    @Resource
    private SessionService sessionService;


    //查看培训信息
    @RequestMapping("toShowTrain")
    protected String toShowTrain(@RequestParam(name = "currentPage", required = false) Integer currentPage, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        String status = "0";
        String status1 = request.getParameter("status");
        if (status1 != null) {
            status = status1;
        }
        List<Train> list = trainService.getALLTrains();
        if(("1").equals(status)){
            list = trainService.getTrainByState(0);//培训草稿
        }else if(("2").equals(status)){
            list = trainService.getTrainByState(1);//已发布的培训
        }else if(("3").equals(status)){
            list = trainService.getTrainByState(2);//已完成的培训
        }

        int cp = 0;
        int pageSize = 8;
        if (currentPage != null) {
            cp = currentPage;
        } else {
            cp = 1;

        }

        if (list != null&&list.size() != 0) {
            int totalRows = list.size();
            int totalPage = GetTotalPage.getTp(totalRows);
            List<List<Train>> list1 = HibernateUtil.split(Train.class, list, pageSize);
            List<Train> trains = HibernateUtil.getSplit(Train.class, list1, cp);
            session.setAttribute("trains", trains);
            session.setAttribute("tp", totalPage);
        } else {
            List<Train> trains = new ArrayList<Train>();
            session.setAttribute("trains", trains);
            session.setAttribute("tp", 1);

        }
        return "showTrain";
    }

    //添加培训
    @RequestMapping("toAddTrain")
    protected String toAddTrain() throws Exception {
        return "addTrain";
    }

    //验证开始时间格式
    @RequestMapping("checkStartTime")
    @ResponseBody
    protected String checkStartTime(String startTime, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        if(startTime != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                Date date = sdf.parse(startTime);
            }catch(ParseException e){
                return "0";
            }
        }
        return "1";
    }


    //验证结束时间格式及是否大于开始时间
    @RequestMapping("checkEndTime")
    @ResponseBody
    protected String checkEndTime(String startTime,String endTime, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        if(endTime != null){
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                Date date = sdf1.parse(startTime);
                Date date1 = sdf1.parse(endTime);
                if(date.getTime() - date1.getTime() >0){
                    return "1";
                }
            }catch(ParseException e){
                return "0";
            }
        }
        return "1";
    }


    @RequestMapping("confirmAddTrain")
    protected String confirmAddTrain(Train train) throws Exception {
        if(train != null){
            boolean isOK = trainService.addTrain(train);
            if(isOK){
                return "forward:toShowTrain";
            }
        }
        return "toAddTrain";
    }


    //修改培训
    @RequestMapping("toUpdateTrain")
    protected String toUpdateTrain(@RequestParam(name = "id", required = false) Integer id,HttpSession session) throws Exception {
        if(id != null&&id != 0){
            Train train = trainService.getTrainById(id);
            if(train != null){
                session.setAttribute("train",train);
                return "updateTrain";
            }
        }
        return "forward:toShowTrain";
    }

    @RequestMapping("confirmUpdateTrain")
    protected String confirmUpdateTrain(Train train) throws Exception {
        if(train != null){
            boolean isOK = trainService.updateTrain(train);
            if(isOK){
                return "forward:toShowTrain";
            }
        }
        return "toUpdateTrain";
    }

    //查看培训详情
    @RequestMapping("toShowTrainDetail")
    protected String toShowTrainDetail(@RequestParam(name = "id",required = false) Integer id,@RequestParam(name = "currentPage", required = false) Integer currentPage,HttpSession session) throws Exception {
        if(id != null&&id != 0){
            Train train = trainService.getTrainById(id);
            List<TrainFand> trainFands = new ArrayList<TrainFand>();

            int cp = 0;
            int pageSize = 8;
            if (currentPage != null) {
                cp = currentPage;
            } else {
                cp = 1;

            }

            if(train != null){
                session.setAttribute("train1",train);
                List<Session> sessions = sessionService.getSessionByTrid(train.getId());
                if(sessions != null&&sessions.size() != 0){
                    for (Session session1 : sessions) {
                        Employee employee = employeeService.getEmployeeById(session1.getEmpid());
                        if(employee != null){
                            Position position = positionService.getPositionById(employee.getPid());
                            Department department = departmentService.getDepartmentById(employee.getDepid());
                            if(position != null&&department != null){
                                trainFands.add(new TrainFand(employee,position,department));
                            }
                        }
                    }
                }

            }

            if (trainFands != null&&trainFands.size() != 0) {
                int totalRows = trainFands.size();
                int totalPage = GetTotalPage.getTp(totalRows);
                List<List<TrainFand>> list1 = HibernateUtil.split(TrainFand.class, trainFands, pageSize);
                List<TrainFand> trainFands1 = HibernateUtil.getSplit(TrainFand.class, list1, cp);
                session.setAttribute("tfs1", trainFands1);
                session.setAttribute("tp", totalPage);
            } else {
                List<TrainFand> trainFands1 = new ArrayList<TrainFand>();
                session.setAttribute("tfs1", trainFands1);
                session.setAttribute("tp", 1);

            }
        }
        return "showTrainDetail";
    }


    //培训前删除
    @RequestMapping("toDelTrain")
    protected String toDelTrain(@RequestParam(name = "id",required = false) Integer id,HttpSession session) throws Exception {
        if(id != null&&id != 0){
            Train train = trainService.getTrainById(id);
            if(train != null){
                trainService.delTrain(train);
            }
        }
        return "forward:toShowTrain";
    }

    //培训后删除
    @RequestMapping("toDelTrain1")
    protected String toDelTrain1(@RequestParam(name = "id",required = false) Integer id,HttpSession session) throws Exception {
        if(id != null&&id != 0){
            Train train = trainService.getTrainById(id);
            if(train != null){
                List<Session> sessions = sessionService.getSessionByTrid(id);
                if(sessions != null&&sessions.size() != 0){
                    for (Session session1 : sessions) {
                        sessionService.delSession(session1);
                    }
                }
                trainService.delTrain(train);
            }
        }
        return "forward:toShowTrain";
    }


    //发布培训
    @RequestMapping("toReleaseTrain")
    protected String toReleaseTrain(@RequestParam(name = "id",required = false) Integer id,HttpServletResponse response,HttpSession session) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        if(id != null&&id != 0){
            Train train2 = trainService.getTrainById(id);
            if(train2 != null){
                session.setAttribute("train2",train2);
                List<Department> departments = departmentService.getAllDepartments();
                session.setAttribute("dts2",departments);
                return "releaseTrain";
            }
        }
        return "forward:toShowTrain";
    }

    //获得员工
    @RequestMapping("getEmployees1")
    @ResponseBody
    protected List<Employee> getEmployees1(Integer depid, HttpServletResponse response, HttpSession session) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        if(depid != null&&depid != 0){
            return employeeService.getEmployeeByDepid(depid);
        }
        return null;
    }

    //发布多人培训
    @RequestMapping("confirmReleaseTtainMany")
    protected String confirmReleaseTtainMany(@RequestParam(name = "trid",required = false) Integer trid,@RequestParam(name = "deid",required = false) Integer deid,HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        if(trid != null&&deid != null&&trid != 0&&deid != 0){
            Train train3 = trainService.getTrainById(trid);
            Department department = departmentService.getDepartmentById(deid);
            if(train3 != null&&department != null){
                train3.setState(1);
                trainService.updateTrain(train3);
                List<Employee> employees = employeeService.getEmployeeByDepid(department.getId());
                if(employees != null&&employees.size() != 0){
                    for (Employee employee : employees) {
                        sessionService.addSession(new Session(train3.getId(),employee.getId()));
                    }
                }
            }
        }
        return "forward:toShowTrain";
    }

    //发布个人培训
    @RequestMapping("confirmReleaseTtain")
    protected String confirmReleaseTtain(@RequestParam(name = "trid",required = false) Integer trid,@RequestParam(name = "empid",required = false) Integer empid,HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        if (trid != null && empid != null && trid != 0 && empid != 0) {
            Train train3 = trainService.getTrainById(trid);
            Employee employee = employeeService.getEmployeeById(empid);
            if (train3 != null && employee != null) {
                train3.setState(1);
                trainService.updateTrain(train3);
                sessionService.addSession(new Session(train3.getId(),employee.getId()));
            }
        }
        return "forward:toShowTrain";
    }
}
