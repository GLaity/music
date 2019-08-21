package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
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
}
