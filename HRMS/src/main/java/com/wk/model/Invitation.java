package com.wk.model;

import java.io.Serializable;

public class Invitation implements Serializable {
    private Integer id;
    private String interviewer;//面试人
    private String company;//公司名称
    private String position;//面试职位
    private String department;//部门
    private String interviewTime;//面试时间
    private String place;//面试地点
    private String contact;//联系人
    private String phone;//联系电话
    private Integer state;//未读/已读
    private Integer vid;

    public Invitation() {
    }

    public Invitation(String interviewer, String company, String position, String department, String interviewTime, String place, String contact, String phone, Integer state, Integer vid) {
        this.interviewer = interviewer;
        this.company = company;
        this.position = position;
        this.department = department;
        this.interviewTime = interviewTime;
        this.place = place;
        this.contact = contact;
        this.phone = phone;
        this.state = state;
        this.vid = vid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    @Override
    public String toString() {
        return "Invitation{" +
                "id=" + id +
                ", interviewer='" + interviewer + '\'' +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", interviewTime='" + interviewTime + '\'' +
                ", place='" + place + '\'' +
                ", contact='" + contact + '\'' +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                ", vid=" + vid +
                '}';
    }
}
