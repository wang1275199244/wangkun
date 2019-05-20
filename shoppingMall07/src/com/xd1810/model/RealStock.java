package com.xd1810.model;

import javax.persistence.*;
import java.io.Serializable;


public class RealStock implements Serializable {
    private Integer id;
    private Integer gid;
    private Integer gcount;

    public RealStock() {
    }

    public RealStock(Integer gid, Integer gcount) {
        this.gid = gid;
        this.gcount = gcount;
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
}
