package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Radio  implements Serializable {
    //电台ID
    private Integer rid;
    //电台播放量
    private Integer rsum;
    //电台名
    private String rname;
    //电台简介
    private String rcontext;

    public Radio() {
    }

    public Radio(Integer rid, Integer rsum, String rname, String rcontext) {
        this.rid = rid;
        this.rsum = rsum;
        this.rname = rname;
        this.rcontext = rcontext;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getRsum() {
        return rsum;
    }

    public void setRsum(Integer rsum) {
        this.rsum = rsum;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRcontext() {
        return rcontext;
    }

    public void setRcontext(String rcontext) {
        this.rcontext = rcontext;
    }

    @Override
    public String toString() {
        return "Radio{" +
                "rid=" + rid +
                ", rsum=" + rsum +
                ", rname='" + rname + '\'' +
                ", rcontext='" + rcontext + '\'' +
                '}';
    }
}
