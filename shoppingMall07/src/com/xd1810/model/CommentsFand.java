package com.xd1810.model;

import java.io.Serializable;

public class CommentsFand implements Serializable {
    private Integer id;
    private Good good;
    private String comment;
    private User user;

    public CommentsFand() {
    }

    public CommentsFand(Integer id, Good good, String comment, User user) {
        this.id = id;
        this.good = good;
        this.comment = comment;
        this.user = user;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
