package com.wk.dao;

import com.wk.model.JobApplication;

import java.util.List;

public interface JobApplicationDao {
    int addJobApplication(JobApplication jobApplication);
    int delJobApplication(JobApplication jobApplication);
    int updateJobApplication(JobApplication jobApplication);
    List<JobApplication> getAllJobApplications();
    List<JobApplication> getJobApplicationByRiid(Integer riid);//招聘信息ID
    List<JobApplication> getJobApplicationByRid(Integer rid);//简历ID
    List<JobApplication> getJobApplicationByState(Integer state);
    JobApplication getJobApplicationByRiidAndRid(Integer riid,Integer rid);
}
