package com.wk.controller;

import com.wk.model.AttendanceRecord;
import com.wk.model.Employee;
import com.wk.model.RewardPunishment;
import com.wk.service.AttendanceRecordService;
import com.wk.service.RewardPunishmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class AttendanceRecordController {
    @Resource
    private AttendanceRecordService arService;
    @Resource
    private RewardPunishmentService rpService;

    @RequestMapping("toClockIn")
    protected String toClockIn (HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception{
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(new Date());
            AttendanceRecord record = new AttendanceRecord(employee.getId(), date);
            AttendanceRecord record1 = arService.getAttendanceRecordByEmpidAndDate(record);
            if(record1 != null){
                request.setAttribute("strin","下班打卡");
            }else {
                request.setAttribute("strin","上班打卡");
            }
        }
        return "clockIn";
    }

    @RequestMapping("confirmAttendance")
    @ResponseBody
    protected String confirmAttendance (String io,String time,HttpServletResponse response, HttpSession session) throws Exception{
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        if(io != null){
            if("上班打卡".equals(io)){
                if(time != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = null;
                    try {
                        date = sdf.parse(time);
                    } catch (ParseException e) {
                        System.out.println("日期格式错误");
                    }
                    Employee employee = (Employee) session.getAttribute("employee");
                    if (employee != null) {
                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
                        String date1 = sdf1.format(date);
                        String clockIn = sdf2.format(date);
                        Integer state = -1;//防止未打下班卡的异常记录
                        AttendanceRecord ar = new AttendanceRecord(employee.getId(),date1,clockIn,state);
                        AttendanceRecord record = new AttendanceRecord(employee.getId(), date1);
                        AttendanceRecord record1 = arService.getAttendanceRecordByEmpidAndDate(record);
                        if(record1 ==null) {
                            arService.addAttendanceRecord(ar);
                        }
                    }
            }
        }else if("下班打卡".equals(io)) {
                Employee employee = (Employee) session.getAttribute("employee");
                if (employee != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String date = sdf.format(new Date());
                    AttendanceRecord record = new AttendanceRecord(employee.getId(), date);
                    AttendanceRecord record1 = arService.getAttendanceRecordByEmpidAndDate(record);
                    if(record1.getClockOut() == null) {
                        String clockIn = record1.getClockIn();
                        if (time != null) {
                            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
                            SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
                            SimpleDateFormat sdf3 = new SimpleDateFormat("HH");
                            Date date1 = null;
                            Date date2 = null;
                            Date date3 = null;
                            try {
                                date1 = sdf2.parse(time);
                            } catch (ParseException e) {
                                System.err.println("日期格式错误");
                            }
                            try {
                                date2 = sdf2.parse(clockIn);
                            } catch (ParseException e) {
                                System.err.println("日期格式错误");
                            }

                            try {
                                date3 = sdf4.parse(record1.getDate());
                            } catch (ParseException e) {
                                System.err.println("日期格式错误");
                            }
                            String clockOut = sdf2.format(date1);
                            String time1 = sdf3.format(date2);//上班打卡小时
                            String time2 = sdf3.format(date1);//下班打卡小时
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(date3);
                            int tim1 = Integer.parseInt(time1);
                            int tim2 = Integer.parseInt(time2);

                            int state = -1;
                            int attendanceTime = 0;
                            int overtime = 0;
                            if(!(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {//不是周六或周末
                                if ("09".compareTo(time1) >= 0 && "18".compareTo(time2) <= 0) {//18>=time2
                                    state = 0;//正常打卡
                                    attendanceTime = 8;
                                    overtime = tim1 - 18;
                                } else if ("11".compareTo(time1) < 0 || "16".compareTo(time2) > 0) {//11点以后打上班卡或16点以前打下班卡
                                    state = 2;//旷工
                                } else if ("18".compareTo(time2) > 0) {//18点以前打卡
                                    state = 3;//早退
                                    attendanceTime = tim1 - 9 - 1;
                                    overtime = 0;
                                } else if ("09".compareTo(time1) < 0) {//9:00以后打卡
                                    state = 1;//迟到
                                    attendanceTime = 18 - tim2 - 1;//每天8小时，中午隔1小时
                                    overtime = tim1 - 18;
                                }
                            }else {//周六、周末全算加班
                                attendanceTime = 0;
                                overtime = tim1 - 9 - 1;

                            }

                            record1.setClockOut(clockOut);
                            record1.setAttendanceTime(attendanceTime);
                            record1.setOvertime(overtime);
                            record1.setState(state);
                            boolean isOK = arService.updateAttendanceRecord(record1);
                            if(isOK){
                                String cause = null;
                                double bonus = 0.00;
                                if(state == 1){
                                    cause = "迟到";
                                    bonus = -50.00;

                                }else if(state == 2){
                                     cause = "旷工";
                                    bonus = -300.00;
                                }else if(state == 3){
                                     cause = "早退";
                                     bonus = -50.00;
                                }
                                RewardPunishment punishment = new RewardPunishment(employee.getId(), cause, bonus, date);
                                rpService.addRewardPunishment(punishment);
                            }
                        }
                    }
                }
            }
        }
        return "forward:toClockIn";
    }
}
