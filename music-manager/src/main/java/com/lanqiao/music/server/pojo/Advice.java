package com.lanqiao.music.server.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;


@Component
public class Advice  implements Serializable {
    //评论ID
    private Integer aid;
    //音乐id
    private Integer mid;
    //用户编号
    private Integer uid;
    //评论内容
    private String atext;
    //评论日期
    private Date adate;

    public Advice() {
    }

    public Advice(Integer aid, Integer mid, Integer uid, String atext, Date adate) {
        this.aid = aid;
        this.mid = mid;
        this.uid = uid;
        this.atext = atext;
        this.adate = adate;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAtext() {
        return atext;
    }

    public void setAtext(String atext) {
        this.atext = atext;
    }

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "aid=" + aid +
                ", mid=" + mid +
                ", uid=" + uid +
                ", atext='" + atext + '\'' +
                ", adate=" + adate +
                '}';
    }
}
