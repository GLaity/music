package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Advice {
    //评论ID
    private Integer aid;
    //音乐id
    private Integer mid;
    //用户编号
    private Integer uid;
    //评论内容
    private String atext;

}
