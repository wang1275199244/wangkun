package com.wk.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.wk.model.*;
import com.wk.service.*;
import com.wk.utils.GetTotalPage;
import com.wk.utils.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
public class RecruitmentController {
    @Resource
    private RecruitmentInformationService rtfService;
    @Resource
    private JobApplicationService jobApplicationService;
    @Resource
    private RecruitmentInformationService ris;
    @Resource
    private ResumeService resumeService;
    @Resource
    private InvitationService invitationService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private PositionService positionService;
    @Resource
    private EmployeeService employeeService;



    @RequestMapping("beforeindex")
    public String showRecruitmentInformation(@RequestParam(name = "currentPage", required = false) Integer currentPage, HttpServletResponse response, HttpSession session) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        int cp = 0;
        int pageSize = 8;
        if (currentPage != null) {
            cp = currentPage;
        } else {
            cp = 1;
        }

        Integer state = 1;
        List<RecruitmentInformation> recruitmentInformations = rtfService.getRecruitmentInformationsByState(state);
        if (recruitmentInformations != null && recruitmentInformations.size() != 0) {
            int totalRows = recruitmentInformations.size();
            int totalPage = GetTotalPage.getTp(totalRows);
            List<List<RecruitmentInformation>> list1 = HibernateUtil.split(RecruitmentInformation.class, recruitmentInformations, pageSize);
            List<RecruitmentInformation> recruitmentInformations1 = HibernateUtil.getSplit(RecruitmentInformation.class, list1, cp);

            session.setAttribute("recruitmentInformations", recruitmentInformations1);
            session.setAttribute("tp", totalPage);

        } else {
            List<RecruitmentInformation> recruitmentInformations1 = new ArrayList<RecruitmentInformation>();
            session.setAttribute("recruitmentInformations", recruitmentInformations1);
            session.setAttribute("tp", 1);
        }
        return "../../index";
    }

    @RequestMapping("showPositionDetail")
    protected String showPositionDetail(@RequestParam(name = "id", required = false) Integer id, HttpServletResponse response, HttpSession session) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");

        RecruitmentInformation recruitmentInformation = rtfService.getRecruitmentInformationsById(id);
        session.setAttribute("rtf", recruitmentInformation);
        return "positionDetail";
    }

    //选择简历
    @RequestMapping("toSelectResume")
    protected String toSelectResume(@RequestParam(name = "id", required = false) Integer id, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (id != null && id != 0) {
            session.setAttribute("riid", id);
        }
        if (visitor == null) {//没有登陆
            return "forward:visitorLogin";
        } else {//已经登录

            String currentPage = request.getParameter("currentPage");
            int cp = 0;
            int pageSize = 8;
            if (currentPage != null) {
                cp = Integer.parseInt(currentPage);
            } else {
                cp = 1;
            }

            List<Resume> resumeList = resumeService.getResumeByVid(visitor.getId());
            if (resumeList != null && resumeList.size() != 0) {
                int totalRows = resumeList.size();
                int totalPage = GetTotalPage.getTp(totalRows);
                List<List<Resume>> list1 = HibernateUtil.split(Resume.class, resumeList, pageSize);
                List<Resume> resumesList1 = HibernateUtil.getSplit(Resume.class, list1, cp);
                session.setAttribute("resumeList", resumesList1);
                session.setAttribute("tp", totalPage);

            } else {
                List<Resume> resumesList1 = new ArrayList<Resume>();
                session.setAttribute("resumeList", resumesList1);
                session.setAttribute("tp", 1);
            }
        }
        return "selectResume";
    }

    //申请岗位
    @RequestMapping("toApplicationJob")
    public String toApplicationJob(@RequestParam(name = "id", required = false) Integer id, HttpSession session) throws Exception {
        if (id != null && id != 0) {
            Resume resume = resumeService.getResumeById(id);
            if (resume != null) {
                session.setAttribute("resume2", resume);
            }
        }
        return "applicationJob";
    }

    //确认投递简历
    @RequestMapping("confirmApplicationJob")
    public String confirmApplicationJob(@RequestParam(name = "id", required = false) Integer id, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        Integer riid = (Integer) session.getAttribute("riid");//招聘信息id
        if(riid != null&&id != null&&riid != 0&& id != 0){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(new Date());
            Integer state = 0;
            JobApplication jobApplication = new JobApplication(riid,id,date,state);
            boolean isOK = jobApplicationService.addJobApplication(jobApplication);
            if(isOK){
                request.setAttribute("str","简历投递成功");
            }else {
                request.setAttribute("str","简历投递失败");
            }



        }

        return "jobApplicationResult";
    }

    @RequestMapping("toShowAppJob")
    public String toShowAppJob(HttpServletResponse response, HttpSession session)throws Exception {
        return "forward:showAppJob";
    }

    @RequestMapping("showAppJob")
    public String showAppJob(@RequestParam(name = "currentPage",required = false)Integer currentPage, HttpServletResponse response, HttpSession session)throws Exception{
        response.setHeader("Content-Type","text/html;charset=UTF-8");

        int cp = 0;
        int pageSize = 8;
        if(currentPage != null){
            cp = currentPage;
        }else {
            cp = 1;
        }

        List<JobApplication> jacs = jobApplicationService.getAllJobApplications();

        List<FandRecruitmentInformation> fris = new ArrayList<FandRecruitmentInformation>();
        if(jacs != null&&jacs.size() != 0) {
            for (int i = 0; i < jacs.size(); i++) {
                RecruitmentInformation information = ris.getRecruitmentInformationsById(jacs.get(i).getRiid());
                fris.add(new FandRecruitmentInformation(jacs.get(i).getId(),jacs.get(i).getState(),jacs.get(i).getDate(),information));

            }
            if (fris != null&&fris.size() != 0) {
                    int totalRows = fris.size();
                    int totalPage = GetTotalPage.getTp(totalRows);
                    List<List<FandRecruitmentInformation>> list1 = HibernateUtil.split(FandRecruitmentInformation.class, fris, pageSize);
                    List<FandRecruitmentInformation> fris1 = HibernateUtil.getSplit(FandRecruitmentInformation.class, list1, cp);
                    session.setAttribute("fris", fris1);
                    session.setAttribute("tp", totalPage);
                } else {
                    List<FandRecruitmentInformation> fris1 = new ArrayList<FandRecruitmentInformation>();
                    session.setAttribute("fris", fris1);
                    session.setAttribute("tp", 1);
                }
            }

        return "showAppJob";
    }

    @RequestMapping("toGetAppResume")
    public String toGetAppResume()throws Exception {
        return "forward:getAppResume";
    }

    @RequestMapping("getAppResume")
    public String getAPPResume(@RequestParam(name = "id",required = false)Integer id,@RequestParam(name = "currentPage",required = false)Integer currentPage, HttpServletResponse response, HttpSession session)throws Exception{
        response.setHeader("Content-Type","text/html;charset=UTF-8");

        int cp = 0;
        int pageSize = 8;
        if(currentPage != null){
            cp = currentPage;
        }else {
            cp = 1;
        }
        if(id != null&&id != 0){
            session.setAttribute("appRiid",id);

        List<JobApplication> jacs = jobApplicationService.getJobApplicationByRiid(id);
        List<Resume> resumeList = new ArrayList<Resume>();
        if(jacs != null&&jacs.size() != 0) {
            for (int i = 0; i < jacs.size(); i++) {
                Resume resume = resumeService.getResumeById(jacs.get(i).getRid());
                resumeList.add(resume);
            }
            if (resumeList != null&&resumeList.size() != 0) {
                int totalRows = resumeList.size();
                int totalPage = GetTotalPage.getTp(totalRows);
                List<List<Resume>> list1 = HibernateUtil.split(Resume.class, resumeList, pageSize);
                List<Resume> resumeList1 = HibernateUtil.getSplit(Resume.class, list1, cp);
                session.setAttribute("resumeList1", resumeList1);
                session.setAttribute("tp", totalPage);

            } else {
                List<Resume> resumeList1 = new ArrayList<Resume>();
                session.setAttribute("resumeList1", resumeList1);
                session.setAttribute("tp", 1);
            }
        }
        }
        return "getAppResume";
    }

    //查看已投简历详情
    @RequestMapping("toAppJob")
    public String toAppJob(@RequestParam(name = "id",required = false)Integer id,HttpSession session)throws Exception {
        if(id != null&&id != 0){
            session.setAttribute("appRid",id);
            Integer riid = (Integer) session.getAttribute("appRiid");
            if(riid != null&&riid != 0){
                JobApplication jobApplication = jobApplicationService.getJobApplicationByRiidAndRid(riid, id);
                if(jobApplication != null){
                    Integer state = 1;//简历已读
                    jobApplication.setState(state);
                    jobApplicationService.updateJobApplication(jobApplication);
                }
            }
            Resume resume = resumeService.getResumeById(id);
            if(resume != null){
                session.setAttribute("resume2",resume);
            }
        }
        return "appJobResume";
    }

    @RequestMapping("toSendInvitation")
    public String toSendInvitation()throws Exception {
        return "forward:addInvitation";
    }

    @RequestMapping("addInvitation")
    public String addInvitation(HttpServletResponse response, HttpSession session)throws Exception{
        response.setHeader("Content-Type","text/html;charset=UTF-8");

        Integer riid = (Integer) session.getAttribute("appRiid");
        Integer rid = (Integer) session.getAttribute("appRid");
        if(riid != null&&rid != null&&riid != 0&&rid != 0) {
            Resume resume = resumeService.getResumeById(rid);
            RecruitmentInformation recruitmentInformation = ris.getRecruitmentInformationsById(riid);
            if(resume != null&&recruitmentInformation != null){
                Invitation invitation = new Invitation();
                invitation.setInterviewer(resume.getName());
                invitation.setPosition(recruitmentInformation.getPosition());
                invitation.setDepartment(recruitmentInformation.getDepartment());
                Integer state = 0;//
                invitation.setState(state);
                invitation.setVid(resume.getVid());
                session.setAttribute("invitation",invitation);
            }


        }
        return "addInvitation";
    }

    @RequestMapping("toConfirmInvitation")
    public String toConfirmInvitation()throws Exception {
        return "forward:confirmInvitation";
    }

    @RequestMapping("confirmInvitation")
    public String confirmInvitation(Invitation invitation,HttpServletResponse response, HttpSession session)throws Exception{
        response.setHeader("Content-Type","text/html;charset=UTF-8");

        if (invitation != null) {
            Integer riid = (Integer) session.getAttribute("appRiid");
            Integer rid = (Integer) session.getAttribute("appRid");
            if(riid != null&&rid != null&&riid != 0&&rid != 0) {
                JobApplication jobApplication = jobApplicationService.getJobApplicationByRiidAndRid(riid, rid);
                if(jobApplication != null){
                    Integer state = 2;//发出面试邀请
                    jobApplication.setState(state);
                    boolean flag = jobApplicationService.updateJobApplication(jobApplication);
                       if(flag){
                           boolean isOK = invitationService.addInvitation(invitation);
                           if(isOK){

                               return "forward:adminManagement";
                           }
                       }
                   }
            }

        }

        return "toAppJob";
    }

    //查看已接受的面试邀请
    @RequestMapping("toGetAcceptInvitation")
    public String toGetAcceptInvitation(HttpServletResponse response,HttpSession session)throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        Integer state = 1;
        List<Invitation> invitationList = invitationService.getInvitationByState(state);
        session.setAttribute("invitationList",invitationList);
        return "getAcceptInvitation";

    }

    //安排面试
    @RequestMapping("toArrangeInterview")
    public String toArrangeInterview(@RequestParam(name = "id",required = false)Integer id,HttpServletResponse response,HttpSession session)throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
            if(id != null&&id != 0){
                Invitation invitation = invitationService.getInvitationById(id);
                session.setAttribute("inv",invitation);
            }
            return "toEmployed";
    }

    //录用
    @RequestMapping("confirmEmployed")
    public String confirmEmployed(@RequestParam(name = "id",required = false)Integer id,HttpServletResponse response,HttpSession session)throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        if(id != null&&id != 0){
            Invitation invitation = invitationService.getInvitationById(id);
            invitation.setState(3);
            invitationService.updateInvitation(invitation);
            Integer riid = (Integer) session.getAttribute("appRiid");
            Integer rid = (Integer) session.getAttribute("appRid");
            if(riid != null&&rid != null&&riid != 0&&rid != 0) {
                JobApplication jobApplication = jobApplicationService.getJobApplicationByRiidAndRid(riid, rid);
                if(jobApplication != null){
                    Integer state = 6;//面试成功
                    jobApplication.setState(state);
                    boolean flag = jobApplicationService.updateJobApplication(jobApplication);
                    RecruitmentInformation information = ris.getRecruitmentInformationsById(riid);
                    String department1 = information.getDepartment();
                    String position1 = information.getPosition();
                    Department department = departmentService.getDepartmentByName(department1);
                    Position position = positionService.getPositionByName(position1);
                    Resume resume = resumeService.getResumeById(rid);
                    if(resume != null) {
                        String str = resume.getEmail();
                        String[] ss = str.split("@");
                        String pass = null;
                        if(ss != null&&ss.length != 0){
                            pass = ss[0];
                        }
                        String s = resume.getBirthDate();
                        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM");
                        long date = 0;
                        try {
                            Date date1 = sdf2.parse(s);
                            date = date1.getTime();
                        }catch(ParseException e){
                            System.err.println("字符串格式错误");
                        }
                        int age1 = (int)((new Date().getTime() - date)/946080000000L);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String entryTime = sdf.format(new Date());
                        Integer age = age1;
                        Integer state1 = 0;//进入试用期
                        Employee employee = new Employee(resume.getPhone(),pass,resume.getName(),resume.getSex(),age,resume.getPhone(),resume.getEmail(),department.getId(),position.getId(),resume.getDegree(),resume.getGraduateSchool(),resume.getMajor(),entryTime,state1);
                        employeeService.addEmployee(employee);

                    }
                }
            }
        }
        return "forward:adminManagement";
    }

    //不录用
    @RequestMapping("confirmUnemployed")
    public String confirmUnemployed(@RequestParam(name = "id",required = false)Integer id,HttpSession session)throws Exception {

        if(id != null&&id != 0){
            Invitation invitation = invitationService.getInvitationById(id);
            invitation.setState(4);
            invitationService.updateInvitation(invitation);
            Integer riid = (Integer) session.getAttribute("appRiid");
            Integer rid = (Integer) session.getAttribute("appRid");
            if(riid != null&&rid != null&&riid != 0&&rid != 0) {
                JobApplication jobApplication = jobApplicationService.getJobApplicationByRiidAndRid(riid, rid);
                if(jobApplication != null){
                    Integer state = 5;//面试失败
                    jobApplication.setState(state);
                    jobApplicationService.updateJobApplication(jobApplication);

                }
            }
        }
        return "forward:adminManagement";
    }
}
