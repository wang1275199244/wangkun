package com.wk.controller;

import com.wk.model.JobApplication;
import com.wk.model.RecruitmentInformation;
import com.wk.model.Resume;
import com.wk.model.Visitor;
import com.wk.service.JobApplicationService;
import com.wk.service.RecruitmentInformationService;
import com.wk.service.ResumeService;
import com.wk.utils.GetTotalPage;
import com.wk.utils.HibernateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RecruitmentInformationController {
    @Resource
    private RecruitmentInformationService recruitmentInformationService;
    @Resource
    private JobApplicationService jobApplicationService;
    @Resource
    private ResumeService resumeService;

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
        List<RecruitmentInformation> recruitmentInformations = recruitmentInformationService.getRecruitmentInformationsByState(state);
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

        RecruitmentInformation recruitmentInformation = recruitmentInformationService.getRecruitmentInformationsById(id);
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
    public String confirmApplicationJob(@RequestParam(name = "id", required = false) Integer id,HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
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
}
