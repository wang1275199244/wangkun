package com.xd1810.model;


import java.io.Serializable;

public class Good implements Serializable {
    private Integer id;
    private String name;
    private Double price;
    private String type;
    private String description;
    private String factory;
    private Integer state;//0 未上架 1 已上架

    public Good() {
    }

    public Good(String name, Double price, String type, String description, String factory) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.factory = factory;

    }

    public Good(String name, Double price, String type, String description, String factory, Integer state) {
        this(name,price,type,description,factory);
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


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return  "商品ID:" + id +
                ",商品名称:" + name +
                ",商品价格:" + price +
                ",商品类型:" + type +
                ", 描述信息:" + description +
                ", 商品产地:" + factory;
    }
}
