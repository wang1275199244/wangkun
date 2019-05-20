package com.wk.dao;

import com.wk.model.RecruitmentInformation;

import java.util.List;

public interface RecruitmentInformationDao {
    List<RecruitmentInformation> getAllRecruitmentInformations();
    List<RecruitmentInformation> getRecruitmentInformationsByState(Integer state);
    RecruitmentInformation getRecruitmentInformationsById(Integer id);
    int addRecruitmentInformation(RecruitmentInformation recruitmentInformation);
    int delRecruitmentInformation(RecruitmentInformation recruitmentInformation);
    int updateRecruitmentInformation(RecruitmentInformation recruitmentInformation);

}
