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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Resource
    private AdminService adminService;
    @Resource
    private RecruitmentInformationService recruitmentInformationService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private TrainService trainService;

    //管理员登录部分
    @RequestMapping("toAdminLogin")
    public String toVisitorLogin()throws Exception{
        return "adminLogin";
    }

    @RequestMapping("adminLogin")
    protected String adminLogin(Admin admin,HttpSession session)throws Exception {
        Admin admin1 = adminService.adminLogin(admin);
        if (admin1 != null) {
            session.setAttribute("admin", admin1);
            return "adminManagement";//登录成功进入管理页面
        } else {
            return "adminLogin";
        }
    }

    //查看所有招聘信息，包括未发布的
    @RequestMapping("toShowAllRI")
    public String toShowAllRI(@RequestParam(name = "currentPage", required = false) Integer currentPage, HttpServletResponse response, HttpSession session) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        int cp = 0;
        int pageSize = 8;
        if (currentPage != null) {
            cp = currentPage;
        } else {
            cp = 1;
        }

        List<RecruitmentInformation> ris = recruitmentInformationService.getAllRecruitmentInformations();
        if (ris != null && ris.size() != 0) {
            int totalRows = ris.size();
            int totalPage = GetTotalPage.getTp(totalRows);
            List<List<RecruitmentInformation>> list = HibernateUtil.split(RecruitmentInformation.class, ris, pageSize);
            List<RecruitmentInformation> ris1 = HibernateUtil.getSplit(RecruitmentInformation.class, list, cp);

            session.setAttribute("ris", ris1);
            session.setAttribute("tp", totalPage);

        } else {
            List<RecruitmentInformation> ris1 = new ArrayList<RecruitmentInformation>();
            session.setAttribute("ris", ris1);
            session.setAttribute("tp", 1);
        }
        return "showAllRI";
    }

    @RequestMapping("toGetPositionDetail")
    protected String toGetPositionDetail(@RequestParam(name = "id", required = false) Integer id, HttpServletResponse response, HttpSession session) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        RecruitmentInformation recruitmentInformation = recruitmentInformationService.getRecruitmentInformationsById(id);
        session.setAttribute("rtf", recruitmentInformation);
        return "getPositionDetail";
    }

    @RequestMapping("toAddInformation")
    protected String toAddInformation(HttpServletResponse response, HttpSession session) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        List<Department> departments = departmentService.getAllDepartments();
        session.setAttribute("dts",departments);
        return "addInformation";
    }

    @RequestMapping("getALLOptions")
    @ResponseBody
    protected List<Position> getALLOptions(String name, HttpServletResponse response, HttpSession session) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        Department department = departmentService.getDepartmentByName(name);
        if(department != null){
            return positionService.getPositionByDepid(department.getId());
        }
        return null;
    }

    @RequestMapping("confirmAddInformation")
    protected String confirmAddInformation(RecruitmentInformation recruitmentInformation, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        if(recruitmentInformation != null){
            recruitmentInformation.setState(0);
            boolean isOK = recruitmentInformationService.addRecruitmentInformation(recruitmentInformation);
            if(isOK){
                return "forward:toShowAllRI";
            }
        }

        return "forward:toAddInformation";
    }

    //发布招聘信息
    @RequestMapping("toPublishformation")
    protected String toPublishformation(@RequestParam(name = "id", required = false) Integer id) throws Exception {

        RecruitmentInformation recruitmentInformation = recruitmentInformationService.getRecruitmentInformationsById(id);
        if(recruitmentInformation != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String releaseDate = sdf.format(new Date());
            recruitmentInformation.setState(1);
            recruitmentInformation.setReleaseDate(releaseDate);
            recruitmentInformationService.updateRecruitmentInformation(recruitmentInformation);
        }
        return "forward:toShowAllRI";
    }

    //撤销发布的招聘信息
    @RequestMapping("toUnpublishInformation")
    protected String toUnpublishInformation(@RequestParam(name = "id", required = false) Integer id) throws Exception {

        RecruitmentInformation recruitmentInformation = recruitmentInformationService.getRecruitmentInformationsById(id);
        if(recruitmentInformation != null){
            recruitmentInformation.setState(0);
            recruitmentInformationService.updateRecruitmentInformation(recruitmentInformation);
        }
        return "forward:toShowAllRI";
    }

    @RequestMapping("toDelInformation")
    protected String toDelInformation(@RequestParam(name = "id", required = false) Integer id, HttpServletResponse response) throws Exception {

        RecruitmentInformation recruitmentInformation = recruitmentInformationService.getRecruitmentInformationsById(id);
        if(recruitmentInformation != null){
            recruitmentInformationService.delRecruitmentInformation(recruitmentInformation);
        }
        return "forward:toShowAllRI";
    }

    //部门管理
    @RequestMapping("toShowDepartment")
    protected String toShowDepartment( HttpServletResponse response,HttpSession session) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        List<Department> departments = departmentService.getAllDepartments();
        session.setAttribute("dts1",departments);
        return "showDepartment";
    }

    //获得职位
    @RequestMapping("getPositions")
    @ResponseBody
    protected List<Position> getPositions(Integer depid, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        if(depid != null&&depid != 0){
            return positionService.getPositionByDepid(depid);
        }
        return null;
    }

    //获得员工
    @RequestMapping("getEmployees")
    @ResponseBody
    protected List<Employee> getEmployees(Integer pid, HttpServletResponse response, HttpSession session) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        if(pid != null&&pid != 0){
            return employeeService.getEmployeeByPid(pid);
        }
        return null;
    }

    //验证增添部门重名
    @RequestMapping("checkDepName")
    @ResponseBody
    protected String checkDepName(String depname, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        if(depname != null){
            Department department = departmentService.getDepartmentByName(depname);
            if(department != null){
                return "0";
            }
        }
        return "1";
    }

    //添加部门
    @RequestMapping("toAddDepartment")
    protected String toAddDepartment(String depname) throws Exception {
       if(depname != null){
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
           String create_time = sdf.format(new Date());
           Department department = new Department(depname,create_time);
           departmentService.addDepartment(department);
       }
        return "forward:toShowDepartment";
    }

    //验证修改部门重名
    @RequestMapping("checkDepName1")
    @ResponseBody
    protected String checkDepName1(String depname1, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        if(depname1 != null){
            Department department1 = departmentService.getDepartmentByName(depname1);
            if(department1 != null){
                return "0";
            }
        }
        return "1";
    }

    //修改部门
    @RequestMapping("toUpdateDep")
    protected String toUpdateDep(String depname1,Integer did) throws Exception {
        if(did != null&&did != 0){
            Department department = departmentService.getDepartmentById(did);
            if (department != null&&depname1 != null) {
                department.setName(depname1);
                departmentService.updateDepartment(department);
            }
        }
        return "forward:toShowDepartment";
    }

    //删除部门
    @RequestMapping("toDelDep")
    protected String toDelDep(Integer deid) throws Exception {
        if(deid != null&&deid != 0) {
            Department department = departmentService.getDepartmentById(deid);
            if (department == null) {
                departmentService.delDepartment(department);
            } else {
                List<Position> positions = positionService.getPositionByDepid(deid);
                if (positions != null || positions.size() != 0) {

                    List<Employee> employees = employeeService.getEmployeeByDepid(deid);

                    if (employees != null && employees.size() != 0) {
                        for (Employee employee : employees) {
                            if (employee.getState() == 1) {
                                continue;
                            }
                            employeeService.delEmployee(employee);
                        }
                    }
                    for (Position position : positions) {
                        positionService.delPosition(position);
                    }

                }
                departmentService.delDepartment(department);
            }
        }
        return "forward:toShowDepartment";
    }


    //验证增添职位重名
    @RequestMapping("checkPosName")
    @ResponseBody
    protected String checkPosName(Integer deid1,String pname, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        if(deid1 != null&& deid1 != 0){
            List<Position> positions = positionService.getPositionByDepid(deid1);
            if(positions != null&&positions.size() != 0){
                for (Position position : positions) {
                    if(pname != null&&pname.equals(position.getName())){
                        return "0";
                    }
                }
            }
        }
        return "1";
    }

    //添加职位
    @RequestMapping("toAddPosition")
    protected String toAddPosition(Integer deid1,String pname) throws Exception {
        if(deid1 != null&&deid1 != 0&&pname != null){
            Position position = new Position(pname,deid1);
            positionService.addPosition(position);
        }
        return "forward:toShowDepartment";
    }


    //验证修改职位重名
    @RequestMapping("checkPosName1")
    @ResponseBody
    protected String checkPosName1(Integer posid,String pname1, HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        if(posid != null&& posid != 0){
            Position position = positionService.getPositionById(posid);
            if(position != null&&pname1.equals(position.getName())){
                return "0";
            }
        }
        return "1";
    }

    //修改职位
    @RequestMapping("toUpdatePosition")
    protected String toUpdatePosition(Integer posid,String pname1) throws Exception {
        if(posid != null&&posid != 0){
            Position position = positionService.getPositionById(posid);
            if(position != null&&pname1 != null){
                position.setName(pname1);
                positionService.updatePosition(position);
            }
        }
        return "forward:toShowDepartment";
    }

    //删除职位
    @RequestMapping("toDelPosition")
    protected String toDelPosition(Integer posid1) throws Exception {
        if(posid1 != null&&posid1 != 0){
            Position position = positionService.getPositionById(posid1);
            List<Employee> employees = employeeService.getEmployeeByPid(posid1);
            if(position != null){
                if (employees != null && employees.size() != 0) {
                    for (Employee employee : employees) {
                        if (employee.getState() == 1) {
                            continue;
                        }
                        employeeService.delEmployee(employee);
                    }
                }
            }
            positionService.delPosition(position);
        }
        return "forward:toShowDepartment";
    }

    //查看培训信息
    @RequestMapping("toShowTrain")
    protected String toShowTrain(@RequestParam(name = "currentPage", required = false) Integer currentPage, HttpServletRequest request,HttpServletResponse response) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        String status = "0";
        String status1 = request.getParameter("status");
        if (status1 != null) {
            status = status1;
        }

        return "showTrain";
    }
}
