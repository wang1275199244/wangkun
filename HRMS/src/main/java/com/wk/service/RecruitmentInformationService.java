package com.wk.service;

import com.wk.model.RecruitmentInformation;

import java.util.List;

public interface RecruitmentInformationService {
    List<RecruitmentInformation> getAllRecruitmentInformations();
    List<RecruitmentInformation> getRecruitmentInformationsByState(Integer state);
    RecruitmentInformation getRecruitmentInformationsById(Integer id);
    boolean addRecruitmentInformation(RecruitmentInformation recruitmentInformation);
    boolean delRecruitmentInformation(RecruitmentInformation recruitmentInformation);
    boolean updateRecruitmentInformation(RecruitmentInformation recruitmentInformation);
}
