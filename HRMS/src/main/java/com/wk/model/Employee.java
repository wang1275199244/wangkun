package com.wk.model;

import java.io.Serializable;

public class Employee implements Serializable {
    private Integer id;
    private String name;
    private String pass;
    private String realName;
    private String sex;
    private Integer age;
    private String phone;
    private String email;
    private Integer depid;
    private Integer pid;
    private Integer state;//0.试用期1.在职2.离职

    public Employee() {
    }

    public Employee(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public Employee(String name, String pass,String realName, String sex, Integer age, String phone, String email) {
        this(name,pass);
        this.realName = realName;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Employee(String name, String pass,String realName, String sex, Integer age, String phone, String email, Integer depid, Integer pid,Integer state) {
        this(name,pass,realName,sex,age,phone,email);
        this.depid = depid;
        this.pid = pid;
        this.state = state;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", depid=" + depid +
                ", pid=" + pid +
                ", state=" + state +
                '}';
    }
}
