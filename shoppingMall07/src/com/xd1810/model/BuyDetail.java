package com.xd1810.model;

import javax.persistence.*;
import java.io.Serializable;

public class BuyDetail implements Serializable {
    private Integer id;
    private Integer gid;
    private Integer gcount;
    private Integer bcid;

    public BuyDetail() {
    }

    public BuyDetail(Integer gid, Integer bcid) {
        this.gid = gid;
        this.bcid = bcid;
    }

    public BuyDetail(Integer gid, Integer gcount, Integer bcid) {
        this(gid,bcid);
        this.gcount = gcount;
    }

    public BuyDetail(Integer id, Integer gid, Integer gcount, Integer bcid) {
        this(gid,gcount,bcid);
        this.id = id;
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

    public Integer getBcid() {
        return bcid;
    }

    public void setBcid(Integer bcid) {
        this.bcid = bcid;
    }

    @Override
    public String toString() {
        return "BuyDetail{" +
                "id=" + id +
                ", gid=" + gid +
                ", gcount=" + gcount +
                '}';
    }
}
