package com.wk.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.wk.model.*;
import com.wk.service.InvitationService;
import com.wk.service.JobApplicationService;
import com.wk.service.ResumeService;
import com.wk.service.VisitorService;
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
public class ShowVisitorInformationController {
    @Resource
    private ResumeService resumeService;
    @Resource
    private VisitorService visitorService;
    @Resource
    private JobApplicationService jobApplicationService;
    @Resource
    private InvitationService invitationService;

    @RequestMapping("toShowVisitorInformation")
    public String toShowVisitorInformation(HttpServletResponse response,HttpSession session)throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if (visitor == null) {//没有登陆
            return "forward:visitorLogin";
        }
        return "showVisitorInformation";
    }

    @RequestMapping("toShowResume")
    public String toShowResume(HttpServletResponse response,HttpSession session)throws Exception {
        return "forward:showResume";
    }

    @RequestMapping("showResume")
    public String showResume(@RequestParam(name = "currentPage",required = false)Integer currentPage, HttpServletResponse response, HttpSession session)throws Exception{
        response.setHeader("Content-Type","text/html;charset=UTF-8");

        int cp = 0;
        int pageSize = 8;
        if(currentPage != null){
            cp = currentPage;
        }else {
            cp = 1;
        }

        Visitor visitor = (Visitor) session.getAttribute("visitor");
        if(visitor != null) {
            Visitor visitor1 = visitorService.getVisitorById(visitor.getId());
            if (visitor1 != null) {
                List<Resume> resumes = resumeService.getResumeByVid(visitor.getId());
                if (resumes != null && resumes.size() != 0) {
                    int totalRows = resumes.size();
                    int totalPage = GetTotalPage.getTp(totalRows);
                    List<List<Resume>> list1 = HibernateUtil.split(Resume.class, resumes, pageSize);
                    List<Resume> resumes1 = HibernateUtil.getSplit(Resume.class, list1, cp);
                    session.setAttribute("resumes", resumes1);
                    session.setAttribute("tp", totalPage);

                } else {
                    List<Resume> resumes1 = new ArrayList<Resume>();
                    session.setAttribute("resumes", resumes1);
                    session.setAttribute("tp", 1);
                }
            }
        }
        return "showResume";
    }

    @RequestMapping("toAddResume")
    public String toAddResume(HttpServletResponse response)throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        return "toAddResume";
    }

    //添加简历
    @RequestMapping("addResume")
    public String addResume(Resume resume,HttpServletResponse response)throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        boolean idOK = resumeService.addResume(resume);
        if(idOK){
            return "forward:showResume";
        }
        return "toAddResume";
    }

    //简历删除（当岗位申请表状态为4，即接受面试邀请时简历仍然有用不能删除）
    @RequestMapping("delResume")
    public String delResume(@RequestParam(name = "id",required = false)Integer id,HttpServletResponse response)throws Exception {
        if(id != null&&id != 0){
            Resume resume = resumeService.getResumeById(id);
            if(resume != null){
                List<JobApplication> jac = jobApplicationService.getJobApplicationByRid(id);
                if(jac != null&&jac.size() != 0){
                    for (JobApplication jobApplication : jac) {
                        if(jobApplication.getState() != 4){
                            boolean isOK = jobApplicationService.delJobApplication(jobApplication);
                            if(isOK){
                                resumeService.delResume(resume);
                                response.getWriter().write("<script>alert(\"删除成功!\");window.location.href='page/showResume.jsp';</script>");
                                return "forward:showResume";
                            }

                        }
                    }
                }

            }
        }
        response.getWriter().write("<script>alert(\"删除失败!\");window.location.href='page/showResume.jsp';</script>");
        return "forward:showResume";
    }


    @RequestMapping("toUpdateResume")
    public String toUpdateResume(@RequestParam(name = "id",required = false)Integer id,HttpServletResponse response,HttpSession session)throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        if(id != null&&id != 0){
            Resume resume = resumeService.getResumeById(id);
            if(resume != null){
                session.setAttribute("resume",resume);
                return "showUpdateResume";
            }
        }
        return "forward:showResume";
    }

    //修改简历
    @RequestMapping("updateResume")
    public String updateResume(Resume resume,HttpServletResponse response)throws Exception {
        if(resume != null){
            resumeService.updateResume(resume);
        }
        return "forward:showResume";
    }

    //查看简历详情
    @RequestMapping("toShowResumeDetail")
    public String toShowResumeDetail(@RequestParam(name = "id",required = false)Integer id,HttpSession session)throws Exception {
        if(id != null&&id != 0){
            Resume resume = resumeService.getResumeById(id);
            if(resume != null){
                session.setAttribute("resume1",resume);
            }
        }
        return "showResumeDetail";
    }

    //查看面试邀请
    @RequestMapping("toShowInterview")
    public String toShowInterview(HttpServletResponse response,HttpSession session)throws Exception {
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        Visitor visitor = (Visitor) session.getAttribute("visitor");
        Visitor visitor1 = visitorService.getVisitorById(visitor.getId());
        if(visitor1 != null){
            List<Invitation> invitations = invitationService.getInvitationByVid(visitor1.getId());
            session.setAttribute("its",invitations);
        }

        return "showInterview";
    }

    //接受面试邀请
    @RequestMapping("toAcceptInvitation")
    public String toAcceptInvitation(@RequestParam(name = "id",required = false)Integer id,HttpServletResponse response,HttpSession session)throws Exception {
        Integer riid = (Integer) session.getAttribute("appRiid");
        Integer rid = (Integer) session.getAttribute("appRid");
        if(riid != null&&rid != null&&riid != 0&&rid != 0) {
            JobApplication jobApplication = jobApplicationService.getJobApplicationByRiidAndRid(riid, rid);
            if(jobApplication != null){
                jobApplication.setState(4);
               jobApplicationService.updateJobApplication(jobApplication);
                if(id != null&&id != 0){
                    Invitation invitation = invitationService.getInvitationById(id);
                    Integer state = 1;//接受邀请
                    invitation.setState(state);
                    invitationService.updateInvitation(invitation);
                }
            }
        }

        return "toShowInterview";
    }

}
