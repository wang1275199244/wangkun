package com.xd1810.model;

import javax.persistence.*;
import java.io.Serializable;


public class Comment implements Serializable {
    private Integer id;
    private Integer gid;
    private String comment;
    private Integer uid;

    public Comment() {
    }

    public Comment(Integer gid, String comment, Integer uid) {
        this.gid = gid;
        this.comment = comment;
        this.uid = uid;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", gid=" + gid +
                ", comment='" + comment + '\'' +
                ", uid=" + uid +
                '}';
    }
}
