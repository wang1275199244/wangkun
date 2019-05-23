package com.wk.model;

import java.io.Serializable;

public class RewardPunishment implements Serializable {
    private Integer id;
    private Integer empid;
    private String cause;//奖惩原因
    private Double bonus;//奖金
    private String bonusDate;//奖惩时间

    public RewardPunishment() {
    }

    public RewardPunishment(Integer empid, String bonusDate) {
        this.empid = empid;
        this.bonusDate = bonusDate;
    }

    public RewardPunishment(Integer empid, String cause, Double bonus, String bonusDate) {
        this(empid,bonusDate);
        this.cause = cause;
        this.bonus = bonus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public String getBonusDate() {
        return bonusDate;
    }

    public void setBonusDate(String bonusDate) {
        this.bonusDate = bonusDate;
    }

    @Override
    public String toString() {
        return "RewardPunishment{" +
                "id=" + id +
                ", empid=" + empid +
                ", cause='" + cause + '\'' +
                ", bonus=" + bonus +
                ", bonusDate='" + bonusDate + '\'' +
                '}';
    }
}
