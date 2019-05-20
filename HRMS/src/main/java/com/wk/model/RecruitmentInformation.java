package com.wk.model;

import java.io.Serializable;

public class RecruitmentInformation implements Serializable {
    private Integer id;
    private String position;//职位
    private String workExperience;//工作经验
    private String degreeRequired;//学历要求
    private String working;//工作方式：全职/兼职
    private String salaryRange;//薪资范围
    private String releaseDate;//发布日期
    private String workPlace;//工作地点
    private String welfare;//福利待遇
    private String positionDescription;//职位描述
    private String companyInformation;//公司信息
    private String department;//所属部门
    private Integer recruitingNumbers;//招聘人数
    private Integer state;//发布状态

    public RecruitmentInformation() {
    }

    public RecruitmentInformation(String position, String workExperience, String degreeRequired, String working, String salaryRange, String releaseDate, String workPlace, String welfare, String positionDescription, String companyInformation,String department,Integer recruitingNumbers, Integer state) {
        this.position = position;
        this.workExperience = workExperience;
        this.degreeRequired = degreeRequired;
        this.working = working;
        this.salaryRange = salaryRange;
        this.releaseDate = releaseDate;
        this.workPlace = workPlace;
        this.welfare = welfare;
        this.positionDescription = positionDescription;
        this.companyInformation = companyInformation;
        this.department = department;
        this.recruitingNumbers = recruitingNumbers;
        this.state = state;
    }

    public RecruitmentInformation(Integer id, String position, String workExperience, String degreeRequired, String working, String salaryRange, String releaseDate, String workPlace, String welfare, String positionDescription, String companyInformation,String department, Integer recruitingNumbers, Integer state) {
        this(position,workExperience,degreeRequired,working,salaryRange,releaseDate,workPlace,welfare,positionDescription,companyInformation,department,recruitingNumbers,state);
        this.id = id;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getDegreeRequired() {
        return degreeRequired;
    }

    public void setDegreeRequired(String degreeRequired) {
        this.degreeRequired = degreeRequired;
    }

    public String getWorking() {
        return working;
    }

    public void setWorking(String working) {
        this.working = working;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public String getCompanyInformation() {
        return companyInformation;
    }

    public void setCompanyInformation(String companyInformation) {
        this.companyInformation = companyInformation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getRecruitingNumbers() {
        return recruitingNumbers;
    }

    public void setRecruitingNumbers(Integer recruitingNumbers) {
        this.recruitingNumbers = recruitingNumbers;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RecruitmentInformation{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", workExperience='" + workExperience + '\'' +
                ", degreeRequired='" + degreeRequired + '\'' +
                ", working='" + working + '\'' +
                ", salaryRange='" + salaryRange + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", welfare='" + welfare + '\'' +
                ", positionDescription='" + positionDescription + '\'' +
                ", companyInformation='" + companyInformation + '\'' +
                ", department='" + department + '\'' +
                ", recruitingNumbers=" + recruitingNumbers +
                ", state=" + state +
                '}';
    }
}
