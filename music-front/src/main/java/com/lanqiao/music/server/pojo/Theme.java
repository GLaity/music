package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Theme {
    //主题ID
    private Integer themeid;
    //主题名
    private String themename;
}
