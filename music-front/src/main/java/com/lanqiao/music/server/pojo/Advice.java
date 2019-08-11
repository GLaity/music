package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
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

}
