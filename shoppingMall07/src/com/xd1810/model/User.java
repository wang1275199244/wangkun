package com.xd1810.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;


public class User implements Serializable {
    private Integer id;
    private String name;
    private String pass;
    private String sex;
    private Double money;

    public User() {
    }

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User(String name, String pass, String sex) {
        this(name,pass);
        this.sex = sex;
    }

    public User(String name, String pass, Double money) {
        this(name,pass);
        this.money = money;
    }

    public User(String name, String pass, String sex, Double money) {
        this(name,pass,sex);
        this.money = money;
    }

    public User(Integer id,String name, String pass, String sex, Double money) {
        this(name,pass,sex);
        this.id = id;
        this.money = money;
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


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return
                "用户id:" + id +
                ", 用户名:" + name +
                ", 密码:" + pass +
                ", 性别:" + sex +
                ", 账户余额:" + money ;
    }
}
