package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class Language  implements Serializable {
    //语种id
    private Integer langid;
    //语种名
    private String langname;
}
