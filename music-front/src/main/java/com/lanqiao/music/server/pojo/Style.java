package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class Style  implements Serializable {
    //流派id
    private Integer styleid;
    //流派名
    private  String stylename;
}
