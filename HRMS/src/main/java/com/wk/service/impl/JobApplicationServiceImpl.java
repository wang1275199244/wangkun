package com.wk.service.impl;

import com.wk.dao.JobApplicationDao;
import com.wk.model.JobApplication;
import com.wk.service.JobApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("jobApplicationService")
public class JobApplicationServiceImpl implements JobApplicationService {
    @Resource
    private JobApplicationDao jobApplicationDao;

    public boolean addJobApplication(JobApplication jobApplication) {
        if(jobApplication == null){
            return false;
        }
        int row = jobApplicationDao.addJobApplication(jobApplication);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean delJobApplication(JobApplication jobApplication) {
        if(jobApplication == null){
            return false;
        }
        int row = jobApplicationDao.delJobApplication(jobApplication);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean updateJobApplication(JobApplication jobApplication) {
        if(jobApplication == null){
            return false;
        }
        int row = jobApplicationDao.updateJobApplication(jobApplication);
        if(row != 0){
            return true;
        }
        return false;
    }

    public List<JobApplication> getAllJobApplications() {
        return jobApplicationDao.getAllJobApplications();
    }

    public List<JobApplication> getJobApplicationByRiid(Integer riid) {
        if(riid == null||riid == 0){
            return null;
        }
        return jobApplicationDao.getJobApplicationByRiid(riid);
    }

    public List<JobApplication> getJobApplicationByRid(Integer rid) {
        if(rid == null||rid == 0){
            return null;
        }
        return jobApplicationDao.getJobApplicationByRiid(rid);
    }

    public List<JobApplication> getJobApplicationByState(Integer state) {
        if(state == null){
            return null;
        }
        return jobApplicationDao.getJobApplicationByState(state);
    }

    public JobApplication getJobApplicationByRiidAndRid(Integer riid, Integer rid) {
        if(riid == null||rid == null||riid == 0||rid == 0){
            return null;
        }
        return jobApplicationDao.getJobApplicationByRiidAndRid(riid,rid);
    }
}
