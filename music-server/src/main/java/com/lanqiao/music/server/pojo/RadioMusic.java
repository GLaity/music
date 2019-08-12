package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class RadioMusic {
    //电台id
    private Integer rid;
    //音乐ID
    private Integer mid;
}
