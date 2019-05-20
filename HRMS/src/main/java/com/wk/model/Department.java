package com.wk.model;

import java.io.Serializable;

public class Department implements Serializable {
    private Integer id;
    private String name;
    private String create_time;//部门创建时间

    public Department() {
    }

    public Department(String name, String create_time) {
        this.name = name;
        this.create_time = create_time;
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

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
