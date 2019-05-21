package com.wk.model;

import java.io.Serializable;

public class Employee implements Serializable {
    private Integer id;
    private String account;//登录账号
    private String pass;
    private String name;
    private String sex;
    private Integer age;
    private String phone;
    private String email;
    private Integer depid;
    private Integer pid;
    private String degree;
    private String graduateSchool;
    private String major;
    private String entryTime;//入职时间
    private Integer state;//0.试用期1.在职2.离职

    public Employee() {
    }

    public Employee(String account, String pass) {
        this.account = account;
        this.pass = pass;
    }

    public Employee(String account, String pass, String name, String sex, Integer age, String phone, String email, Integer depid, Integer pid, String degree, String graduateSchool, String major, String entryTime, Integer state) {
        this(account,pass);
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.depid = depid;
        this.pid = pid;
        this.degree = degree;
        this.graduateSchool = graduateSchool;
        this.major = major;
        this.entryTime = entryTime;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", depid=" + depid +
                ", pid=" + pid +
                ", degree='" + degree + '\'' +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", major='" + major + '\'' +
                ", entryTime='" + entryTime + '\'' +
                ", state=" + state +
                '}';
    }
}
