package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SheetMusic {
    //歌单id
    private Integer sid;
    //音乐id
    private Integer mid;
}
