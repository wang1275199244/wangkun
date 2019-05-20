package com.xd1810.model;

import java.io.Serializable;

public class UserDetail implements Serializable {
    private Integer id;
    private String receiver;
    private String phone;
    private String address;
    private Integer uid;


    public UserDetail() {
    }

    public UserDetail(String receiver, String phone, String address) {
        this.receiver = receiver;
        this.phone = phone;
        this.address = address;
    }
    public UserDetail(String receiver, String phone, String address,Integer uid) {
        this(receiver,phone,address);
        this.uid = uid;
    }
    public UserDetail(Integer id, String receiver, String phone, String address) {
        this(receiver,phone,address);
        this.id = id;
    }

    public UserDetail(Integer id,String receiver, String phone, String address,Integer uid) {
        this(receiver,phone,address,uid);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return
                " 信息详情ID:" + id +
                ", 联系人:" + receiver +
                ", 联系方式:" + phone +
                ", 联系地址:" + address +
                ", 用户:" + uid ;
    }
}
