package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class SheetUser {
    //歌单id
    private Integer sid;
    //歌单名
    private String sname;
    //用户id
    private Integer uid;
    //歌单类型0收藏歌单、1自创歌单、2他人歌单、3购买的歌曲
    private Integer type;

    public SheetUser() {
    }

    public SheetUser(Integer sid, String sname, Integer uid, Integer type) {
        this.sid = sid;
        this.sname = sname;
        this.uid = uid;
        this.type = type;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


}
