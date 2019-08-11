package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Language {
    //语种id
    private Integer langid;
    //语种名
    private String langname;
}
