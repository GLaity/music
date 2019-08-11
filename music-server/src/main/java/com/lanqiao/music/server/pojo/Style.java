package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Style {
    //流派id
    private Integer styleid;
    //流派名
    private  String stylename;
}
