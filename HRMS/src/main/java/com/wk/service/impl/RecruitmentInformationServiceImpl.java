package com.wk.service.impl;

import com.wk.dao.RecruitmentInformationDao;
import com.wk.model.RecruitmentInformation;
import com.wk.service.RecruitmentInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("recruitmentInformationService")
public class RecruitmentInformationServiceImpl implements RecruitmentInformationService {
    @Resource
    private RecruitmentInformationDao recruitmentInformationDao;

    public List<RecruitmentInformation> getAllRecruitmentInformations() {
        return recruitmentInformationDao.getAllRecruitmentInformations();
    }

    public List<RecruitmentInformation> getRecruitmentInformationsByState(Integer state) {
        if(state == null){
            return null;
        }
        return recruitmentInformationDao.getRecruitmentInformationsByState(state);
    }

    public RecruitmentInformation getRecruitmentInformationsById(Integer id) {
        if(id == null&&id == 0){
            return null;
        }
        return recruitmentInformationDao.getRecruitmentInformationsById(id);
    }

    public boolean addRecruitmentInformation(RecruitmentInformation recruitmentInformation) {
        if(recruitmentInformation == null)
        {
            return false;
        }
        int row = recruitmentInformationDao.addRecruitmentInformation(recruitmentInformation);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean delRecruitmentInformation(RecruitmentInformation recruitmentInformation) {
        if(recruitmentInformation == null)
        {
            return false;
        }
        int row = recruitmentInformationDao.delRecruitmentInformation(recruitmentInformation);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean updateRecruitmentInformation(RecruitmentInformation recruitmentInformation) {
        if(recruitmentInformation == null)
        {
            return false;
        }
        int row = recruitmentInformationDao.updateRecruitmentInformation(recruitmentInformation);
        if(row != 0){
            return true;
        }
        return false;
    }
}
