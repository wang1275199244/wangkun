package com.xd1810.model;

import java.io.Serializable;

public class GoodFand implements Serializable {
    private Integer id;
    private Good good;
    private Stock stock;

    public GoodFand() {
    }

    public GoodFand(Good good, Stock stock) {
        this.good = good;
        this.stock = stock;
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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
