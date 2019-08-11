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
}
