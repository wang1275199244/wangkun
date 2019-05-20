package com.wk.model;

import java.io.Serializable;

public class Train implements Serializable {
    private Integer id;
    private String title;//培训主题
    private String content;//培训内容
    private String startTime;//开始时间
    private String endTime;//结束时间
    private String place;//地点
    private Integer empid;
    private Integer state;//0.存入草稿1.发布为培训状态3.培训完成

    public Train() {
    }

    public Train(String title, String content, Integer state) {
        this.title = title;
        this.content = content;
        this.state = state;
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

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", place='" + place + '\'' +
                ", empid=" + empid +
                ", state=" + state +
                '}';
    }
}
