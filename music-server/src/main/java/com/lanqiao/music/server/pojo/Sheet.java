package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
@Component
//歌单
public class Sheet {
//    歌单id
    private Integer sid;
//    歌单播放量
    private Integer ssum;
//    歌单名
    private String sname;
//    歌单简介
    private String scontext;
    //歌单创建时间
    private Date sdate;
    //歌单中歌曲列表
    private List<Music> musicList;

    public Sheet() {
    }

    public Sheet(Integer sid, Integer ssum, String sname, String scontext, Date sdate, List<Music> musicList) {
        this.sid = sid;
        this.ssum = ssum;
        this.sname = sname;
        this.scontext = scontext;
        this.sdate = sdate;
        this.musicList = musicList;
    }

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
        this.sname = sname;
    }

    public String getScontext() {
        return scontext;
    }

    public void setScontext(String scontext) {
        this.scontext = scontext;
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }


}
