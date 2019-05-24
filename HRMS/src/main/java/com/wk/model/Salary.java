package com.wk.model;

import java.io.Serializable;

public class Salary implements Serializable {
    private Integer id;
    private Double baseSalary;//基本工资
    private Double performance;//绩效奖金
    private Double overtimePay;//加班费
    private Double rewardPunish;//奖惩
    private Double security;//社保
    private Double ssalary;//实发工资
    private Integer empid;
    private Integer balstate;//结算状态0.未结算1.已结算
    private String baldate;//结算日期

    public Salary() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getPerformance() {
        return performance;
    }

    public void setPerformance(Double performance) {
        this.performance = performance;
    }

    public Double getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(Double overtimePay) {
        this.overtimePay = overtimePay;
    }

    public Double getRewardPunish() {
        return rewardPunish;
    }

    public void setRewardPunish(Double rewardPunish) {
        this.rewardPunish = rewardPunish;
    }

    public Double getSecurity() {
        return security;
    }

    public void setSecurity(Double security) {
        this.security = security;
    }

    public Double getSsalary() {
        return ssalary;
    }

    public void setSsalary(Double ssalary) {
        this.ssalary = ssalary;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getBalstate() {
        return balstate;
    }

    public void setBalstate(Integer balstate) {
        this.balstate = balstate;
    }

    public String getBaldate() {
        return baldate;
    }

    public void setBaldate(String baldate) {
        this.baldate = baldate;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", baseSalary=" + baseSalary +
                ", performance=" + performance +
                ", overtimePay=" + overtimePay +
                ", rewardPunish=" + rewardPunish +
                ", security=" + security +
                ", ssalary=" + ssalary +
                ", empid=" + empid +
                ", balstate=" + balstate +
                ", baldate='" + baldate + '\'' +
                '}';
    }
}
