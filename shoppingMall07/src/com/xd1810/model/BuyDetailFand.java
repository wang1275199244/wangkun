package com.xd1810.model;

import java.io.Serializable;

public class BuyDetailFand implements Serializable {
    private Integer id;
    private Good good;
    private Integer gcount;
    private BuyCar buyCar;

    public BuyDetailFand() {
    }

    public BuyDetailFand(Integer id,Good good, Integer gcount, BuyCar buyCar) {
        this.id = id;
        this.good = good;
        this.gcount = gcount;
        this.buyCar = buyCar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Integer getGcount() {
        return gcount;
    }

    public void setGcount(Integer gcount) {
        this.gcount = gcount;
    }

    public BuyCar getBuyCar() {
        return buyCar;
    }

    public void setBuyCar(BuyCar buyCar) {
        this.buyCar = buyCar;
    }


}
