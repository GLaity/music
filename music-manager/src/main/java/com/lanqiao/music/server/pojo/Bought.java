package com.lanqiao.music.server.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;


@Component
//购买记录表
public class Bought implements Serializable {
//    单号id
    private Integer bid;
//    用户id
    private Integer uid;
//    服务
    private String service;
//    购买时间
    private Date bdate;
//    交易金额
    private Double bmoney;

    private String user;

    public Bought() {
    }

    public Bought(Integer bid, Integer uid, String service, Date bdate, Double bmoney, String user) {
        this.bid = bid;
        this.uid = uid;
        this.service = service;
        this.bdate = bdate;
        this.bmoney = bmoney;
        this.user = user;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Double getBmoney() {
        return bmoney;
    }

    public void setBmoney(Double bmoney) {
        this.bmoney = bmoney;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bought{" +
                "bid=" + bid +
                ", uid=" + uid +
                ", service='" + service + '\'' +
                ", bdate=" + bdate +
                ", bmoney=" + bmoney +
                ", user='" + user + '\'' +
                '}';
    }
}
