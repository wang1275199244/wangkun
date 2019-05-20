package com.wk.model;

import java.io.Serializable;

public class Position implements Serializable {
    private Integer id;
    private String name;
    private Integer depid;//部门ID

    public Position() {
    }

    public Position(String name, Integer depid) {
        this.name = name;
        this.depid = depid;
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

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", depid=" + depid +
                '}';
    }
}
