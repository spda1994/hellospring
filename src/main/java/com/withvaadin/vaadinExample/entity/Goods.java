package com.withvaadin.vaadinExample.entity;

import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Goods {

    private long id;
    private String goodsName;
    private Double goodsAmount = 0.000;
    private Date time = new Date();

    public Goods(long id, String goodsName, Double goodsAmount, Date time) {
        super();
        this.id = id;
        this.goodsName = goodsName;
        this.goodsAmount = goodsAmount;
        this.time = time;
    }

    public Goods() {
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
