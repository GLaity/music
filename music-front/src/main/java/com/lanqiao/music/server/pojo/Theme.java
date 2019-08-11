package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class Theme  implements Serializable {
    //主题ID
    private Integer themeid;
    //主题名
    private String themename;
}
