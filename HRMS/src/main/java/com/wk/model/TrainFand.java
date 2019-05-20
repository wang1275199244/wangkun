package com.wk.model;

import java.io.Serializable;

public class TrainFand implements Serializable {
    private Integer id;
    private String title;//培训主题
    private String content;//培训内容
    private String startTime;//开始时间
    private String endTime;//结束时间
    private String place;//地点
    private Integer state;//0.存入草稿1.发布为培训状态3.培训完成
    private Employee employee;
    private Position position;
    private Department department;

    public TrainFand() {
    }

    public TrainFand(Integer id, String title, String content, String startTime, String endTime, String place, Integer state, Employee employee, Position position, Department department) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.startTime = startTime;
        this.endTime = endTime;
        this.place = place;
        this.state = state;
        this.employee = employee;
        this.position = position;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "TrainFand{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", place='" + place + '\'' +
                ", state=" + state +
                ", employee=" + employee +
                ", position=" + position +
                ", department=" + department +
                '}';
    }
}
