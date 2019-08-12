package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class RadioMusic implements Serializable {
    //电台id
    private Integer rid;
    //音乐ID
    private Integer mid;
}
