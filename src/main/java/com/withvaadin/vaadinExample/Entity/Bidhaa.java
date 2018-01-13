package com.withvaadin.vaadinExample.Entity;

import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Bidhaa {

    private long id;
    private String goodsName;
    private Double goodsAmount;
    private Date time = new Date();

    public Bidhaa(long id, String goodsName, Double goodsAmount, Date time) {
        super();
        this.id = id;
        this.goodsName = goodsName;
        this.goodsAmount = goodsAmount;
        this.time = time;
    }

    public Bidhaa() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getgoodsName() {
        return goodsName;
    }

    public void setgoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Double goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
