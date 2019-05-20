package com.wk.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.wk.model.*;
import com.wk.service.DepartmentService;
import com.wk.service.EmployeeService;
import com.wk.service.PositionService;
import com.wk.service.TrainService;
import com.wk.utils.GetTotalPage;
import com.wk.utils.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
            List<TrainFand> trainFands = new ArrayList<TrainFand>();
            for (int i = 0; i < trains.size(); i++) {
                Employee employee = employeeService.getEmployeeById(trains.get(i).getEmpid());
                if(employee != null){
                    Position position = positionService.getPositionById(employee.getPid());
                    Department department = departmentService.getDepartmentById(employee.getDepid());
                    trainFands.add(new TrainFand(trains.get(i).getId(),trains.get(i).getTitle(),trains.get(i).getContent(),trains.get(i).getStartTime(),trains.get(i).getEndTime(),trains.get(i).getPlace(),trains.get(i).getState(),employee,position,department));
                }
            }
            session.setAttribute("tfs", trainFands);
            session.setAttribute("tp", totalPage);
        } else {
            List<TrainFand> trainFands = new ArrayList<TrainFand>();
            session.setAttribute("tfs", trainFands);
            session.setAttribute("tp", 1);

        }
        return "showTrain";
    }

    //添加培训
    @RequestMapping("toAddTrain")
    protected String toAddTrain() throws Exception {
        return "addTrain";
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

    //查看培训详情
    @RequestMapping("toShowTrainDetail")
    protected String toShowTrainDetail(@RequestParam(name = "id",required = false) Integer id,HttpSession session) throws Exception {
        if(id != null&&id != 0){
            Train train = trainService.getTrainById(id);
            if(train != null){
                Employee employee = employeeService.getEmployeeById(train.getEmpid());
                if(employee != null){
                    Position position = positionService.getPositionById(employee.getPid());
                    Department department = departmentService.getDepartmentById(employee.getDepid());
                    if(position != null&&department != null){
                        TrainFand trainFand = new TrainFand(train.getId(),train.getTitle(),train.getContent(),train.getStartTime(),train.getEndTime(),train.getPlace(),train.getState(),employee,position,department);
                        session.setAttribute("trainf",trainFand);
                    }

                }
            }
        }
        return "showTrainDetail";
    }


    //删除培训详情
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



}
