package com.wk.service.impl;

import com.wk.dao.ResumeDao;
import com.wk.model.Resume;
import com.wk.service.ResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeDao resumeDao;

    public boolean addResume(Resume resume) {
        if(resume == null){
            return false;
        }
        int row = resumeDao.addResume(resume);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean delResume(Resume resume) {
        if(resume == null){
            return false;
        }
        int row = resumeDao.delResume(resume);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean updateResume(Resume resume) {
        if(resume == null){
            return false;
        }
        int row = resumeDao.updateResume(resume);
        if(row != 0){
            return true;
        }
        return false;
    }

    public Resume getResumeById(Integer id) {
        if(id == null||id == 0){
            return null;
        }
        return resumeDao.getResumeById(id);
    }

    public List<Resume> getResumeByVid(Integer vid) {
        if(vid == null||vid == 0){
            return null;
        }
        return resumeDao.getResumeByVid(vid);
    }
}
