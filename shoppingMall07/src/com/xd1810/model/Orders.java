package com.xd1810.model;

import javax.persistence.*;
import java.io.Serializable;

public class Orders implements Serializable {
    private Integer id;
    private Integer uid;
    private Integer gid;
    private Integer udid;
    private String time;
    private Double money;
    private Integer state;//0:未付款
    private Integer gcount;
    private Integer delivery;//0:未发货

    public Orders() {
    }

    public Orders(Integer uid, Integer gid, Integer udid, String time, Double money, Integer state, Integer gcount, Integer delivery) {
        this.uid = uid;
        this.gid = gid;
        this.udid = udid;
        this.time = time;
        this.money = money;
        this.state = state;
        this.gcount = gcount;
        this.delivery = delivery;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getUdid() {
        return udid;
    }

    public void setUdid(Integer udid) {
        this.udid = udid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getGcount() {
        return gcount;
    }

    public void setGcount(Integer gcount) {
        this.gcount = gcount;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", money=" + money +
                ", state=" + state +
                ", gcount=" + gcount +
                ", delivery=" + delivery +
                '}';
    }
}
