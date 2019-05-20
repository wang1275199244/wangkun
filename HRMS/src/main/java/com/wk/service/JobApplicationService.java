package com.wk.service;

import com.wk.model.JobApplication;

import java.util.List;

public interface JobApplicationService {
    boolean addJobApplication(JobApplication jobApplication);
    boolean delJobApplication(JobApplication jobApplication);
    boolean updateJobApplication(JobApplication jobApplication);
    List<JobApplication> getAllJobApplications();
    List<JobApplication> getJobApplicationByRiid(Integer riid);
    List<JobApplication> getJobApplicationByRid(Integer rid);
    List<JobApplication> getJobApplicationByState(Integer state);
    JobApplication getJobApplicationByRiidAndRid(Integer riid,Integer rid);
}
