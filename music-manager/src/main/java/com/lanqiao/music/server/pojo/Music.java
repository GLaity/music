package com.lanqiao.music.server.pojo;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

@Component
public class Music implements Serializable {
    //音乐ID
    private Integer mid;
    //歌名
    private String mname;
    //歌手
    private String msinger;
    //音乐简介
    private String mcontext;
    //专辑名
    private String malbum;
    //歌曲等级
    private Integer mlevel;
    //主题
    private String mtheme;
    //流派
    private String mstyle;
    //语种
    private String  mlanguage;
    //音乐价格
    private Double mprice;
    //音乐路径
    private String mloc;
    //发行时间
    private Date mdate;

    private MultipartFile img1;

    private MultipartFile img2;

    private MultipartFile img3;

    public Music() {
    }

    public Music(Integer mid, String mname, String msinger, String mcontext, String malbum, Integer mlevel, String mtheme, String mstyle, String mlanguage, Double mprice, String mloc, Date mdate, MultipartFile img1, MultipartFile img2, MultipartFile img3) {
        this.mid = mid;
        this.mname = mname;
        this.msinger = msinger;
        this.mcontext = mcontext;
        this.malbum = malbum;
        this.mlevel = mlevel;
        this.mtheme = mtheme;
        this.mstyle = mstyle;
        this.mlanguage = mlanguage;
        this.mprice = mprice;
        this.mloc = mloc;
        this.mdate = mdate;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMsinger() {
        return msinger;
    }

    public void setMsinger(String msinger) {
        this.msinger = msinger;
    }

    public String getMcontext() {
        return mcontext;
    }

    public void setMcontext(String mcontext) {
        this.mcontext = mcontext;
    }

    public String getMalbum() {
        return malbum;
    }

    public void setMalbum(String malbum) {
        this.malbum = malbum;
    }

    public Integer getMlevel() {
        return mlevel;
    }

    public void setMlevel(Integer mlevel) {
        this.mlevel = mlevel;
    }

    public String getMtheme() {
        return mtheme;
    }

    public void setMtheme(String mtheme) {
        this.mtheme = mtheme;
    }

    public String getMstyle() {
        return mstyle;
    }

    public void setMstyle(String mstyle) {
        this.mstyle = mstyle;
    }

    public String getMlanguage() {
        return mlanguage;
    }

    public void setMlanguage(String mlanguage) {
        this.mlanguage = mlanguage;
    }

    public Double getMprice() {
        return mprice;
    }

    public void setMprice(Double mprice) {
        this.mprice = mprice;
    }

    public String getMloc() {
        return mloc;
    }

    public void setMloc(String mloc) {
        this.mloc = mloc;
    }

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }

    public MultipartFile getImg1() {
        return img1;
    }

    public void setImg1(MultipartFile img1) {
        this.img1 = img1;
    }

    public MultipartFile getImg2() {
        return img2;
    }

    public void setImg2(MultipartFile img2) {
        this.img2 = img2;
    }

    public MultipartFile getImg3() {
        return img3;
    }

    public void setImg3(MultipartFile img3) {
        this.img3 = img3;
    }

    @Override
    public String toString() {
        return "Music{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", msinger='" + msinger + '\'' +
                ", mcontext='" + mcontext + '\'' +
                ", malbum='" + malbum + '\'' +
                ", mlevel=" + mlevel +
                ", mtheme='" + mtheme + '\'' +
                ", mstyle='" + mstyle + '\'' +
                ", mlanguage='" + mlanguage + '\'' +
                ", mprice=" + mprice +
                ", mloc='" + mloc + '\'' +
                ", mdate=" + mdate +
                ", img1=" + img1 +
                ", img2=" + img2 +
                ", img3=" + img3 +
                '}';
    }
}
