package com.wk.model;

import java.io.Serializable;

public class FandRecruitmentInformation implements Serializable {
    private Integer id;
    private Integer viewState;//查看状态
    private String date;//岗位申请提交日期
    private RecruitmentInformation recruitmentInformation;

    public FandRecruitmentInformation() {
    }

    public FandRecruitmentInformation(Integer id, Integer viewState, String date, RecruitmentInformation recruitmentInformation) {
        this.id = id;
        this.viewState = viewState;
        this.date = date;
        this.recruitmentInformation = recruitmentInformation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getViewState() {
        return viewState;
    }

    public void setViewState(Integer viewState) {
        this.viewState = viewState;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RecruitmentInformation getRecruitmentInformation() {
        return recruitmentInformation;
    }

    public void setRecruitmentInformation(RecruitmentInformation recruitmentInformation) {
        this.recruitmentInformation = recruitmentInformation;
    }

    @Override
    public String toString() {
        return "FandRecruitmentInformation{" +
                "id=" + id +
                ", viewState=" + viewState +
                ", date='" + date + '\'' +
                ", recruitmentInformation=" + recruitmentInformation +
                '}';
    }
}
