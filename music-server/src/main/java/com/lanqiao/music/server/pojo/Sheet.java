package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Component
//歌单
public class Sheet implements Serializable {
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
//    private List<Music> musicList;
}
