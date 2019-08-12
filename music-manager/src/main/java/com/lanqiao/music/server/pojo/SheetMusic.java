package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class SheetMusic implements Serializable {
    //歌单id
    private Integer sid;
    //音乐id
    private Integer mid;
}
