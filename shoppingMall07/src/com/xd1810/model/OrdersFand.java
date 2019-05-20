package com.xd1810.model;

import java.io.Serializable;

public class OrdersFand implements Serializable {
    private Integer id;
    private User user;
    private Good good;
    private UserDetail userDetail;
    private String time;
    private Double money;
    private Integer state;
    private Integer gcount;
    private Integer delivery;

    public OrdersFand() {
    }

    public OrdersFand(Integer id, User user, Good good, UserDetail userDetail, String time, Double money, Integer state, Integer gcount, Integer delivery) {
        this.id = id;
        this.user = user;
        this.good = good;
        this.userDetail = userDetail;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
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
}
