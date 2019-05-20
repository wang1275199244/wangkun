package com.wk.model;

import java.io.Serializable;

public class Resume implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private String birthDate;//出生年月
    private String national;//民族
    private String degree;//学历
    private String maritalStatus;//婚姻状况
    private String graduateSchool;//毕业院校
    private String resident;//籍贯
    private String major;//专业
    private String pliticsStatus;//政治面貌
    private String phone;
    private String email;
    private String objective;//求职意向
    private String certificate;//获得证书
    private String workExperience;//工作经历
    private String selfAssessment;//自我评价
    private Integer vid;

    public Resume() {
    }

    public Resume(String name, String sex, String birthDate, String national, String degree, String maritalStatus, String graduateSchool, String resident, String major, String pliticsStatus, String phone, String email, String objective, String certificate, String workExperience, String selfAssessment, Integer vid) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.national = national;
        this.degree = degree;
        this.maritalStatus = maritalStatus;
        this.graduateSchool = graduateSchool;
        this.resident = resident;
        this.major = major;
        this.pliticsStatus = pliticsStatus;
        this.phone = phone;
        this.email = email;
        this.objective = objective;
        this.certificate = certificate;
        this.workExperience = workExperience;
        this.selfAssessment = selfAssessment;
        this.vid = vid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getResident() {
        return resident;
    }

    public void setResident(String resident) {
        this.resident = resident;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPliticsStatus() {
        return pliticsStatus;
    }

    public void setPliticsStatus(String pliticsStatus) {
        this.pliticsStatus = pliticsStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getSelfAssessment() {
        return selfAssessment;
    }

    public void setSelfAssessment(String selfAssessment) {
        this.selfAssessment = selfAssessment;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", national='" + national + '\'' +
                ", degree='" + degree + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", resident='" + resident + '\'' +
                ", major='" + major + '\'' +
                ", pliticsStatus='" + pliticsStatus + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", objective='" + objective + '\'' +
                ", certificate='" + certificate + '\'' +
                ", workExperience='" + workExperience + '\'' +
                ", selfAssessment='" + selfAssessment + '\'' +
                ", vid='" + vid + '\'' +
                '}';
    }
}
