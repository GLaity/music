package com.lanqiao.music.server.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import java.util.Date;
import java.util.Set;


@Component

public class User implements Serializable {
//    用户编号(自增)
    private Integer uid;
//    用户名
    private String uname;
//    用户密码
    private String upwd;
//    账户余额
    private Double ubalance;
//    用户注册时间

    private Date udate;
//    会员到期时间
//    字段为空为非会员，每次登陆检查会员是否过期，过期则提示充值并清空字段

    private Date vdate;
//    用户性别(0为女，1为男)
    private Integer usex;
//    用户联系方式
    private String utel;
//    用户歌单
    private Sheet uCollectionMusic;

    private Sheet uBuyMusic;
    private Set<Sheet> uCreateSheet;
    private Set<Sheet> uCollectionSheet;

    //TODO

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public Double getUbalance() {
        return ubalance;
    }

    public void setUbalance(Double ubalance) {
        this.ubalance = ubalance;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public Date getVdate() {
        return vdate;
    }

    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

    public Integer getUsex() {
        return usex;
    }

    public void setUsex(Integer usex) {
        this.usex = usex;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public User() {
    }

    public User(Integer uid, String uname, String upwd, Double ubalance, Date udate, Date vdate, Integer usex, String utel) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.ubalance = ubalance;
        this.udate = udate;
        this.vdate = vdate;
        this.usex = usex;
        this.utel = utel;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", ubalance=" + ubalance +
                ", udate=" + udate +
                ", vdate=" + vdate +
                ", usex=" + usex +
                ", utel='" + utel + '\'' +
                '}';
    }
}
