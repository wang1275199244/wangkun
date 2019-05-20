package com.xd1810.model;

import javax.persistence.*;
import java.io.Serializable;


public class StockRecord implements Serializable {
    private Integer id;
    private Integer gid;
    private Integer gcount;
    private String time;
    private Integer state;

    public StockRecord() {
    }

    public StockRecord(Integer gid, Integer gcount, String time, Integer state) {
        this.gid = gid;
        this.gcount = gcount;
        this.time = time;
        this.state = state;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getGcount() {
        return gcount;
    }

    public void setGcount(Integer gcount) {
        this.gcount = gcount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
