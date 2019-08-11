package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

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
}
