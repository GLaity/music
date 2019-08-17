package com.lanqiao.music.server.pojo;

import java.util.Date;

public class Sheet {
    private Integer sid;

    private Integer ssum;

    private String sname;

    private String scontext;

    private Date sdate;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getSsum() {
        return ssum;
    }

    public void setSsum(Integer ssum) {
        this.ssum = ssum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getScontext() {
        return scontext;
    }

    public void setScontext(String scontext) {
        this.scontext = scontext == null ? null : scontext.trim();
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }
}