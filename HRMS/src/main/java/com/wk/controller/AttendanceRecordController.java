package com.wk.controller;

import com.wk.model.AttendanceRecord;
import com.wk.model.Employee;
import com.wk.service.AttendanceRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AttendanceRecordController {
    @Resource
    private AttendanceRecordService arService;

    @RequestMapping("toClockIn")
    protected String toClockIn (HttpServletResponse response) throws Exception{
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        return "clockIn";
    }

    @RequestMapping("confirmAttendance")
    protected String confirmAttendance (HttpServletResponse response, HttpSession session) throws Exception{
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String clockIn = sdf.format(new Date());
            arService.addAttendanceRecord(new AttendanceRecord(clockIn));
        }
        return "forward:toAttendanceRecord";
    }
}
