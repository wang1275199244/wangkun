package com.wk.model;

import java.io.Serializable;

public class Session implements Serializable {
    private Integer id;
    private Integer trid;
    private Integer empid;

    public Session() {
    }

    public Session(Integer trid, Integer empid) {
        this.trid = trid;
        this.empid = empid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrid() {
        return trid;
    }

    public void setTrid(Integer trid) {
        this.trid = trid;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }
}
