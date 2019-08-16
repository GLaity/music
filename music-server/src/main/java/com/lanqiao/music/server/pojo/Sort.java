package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Sort {
    private Integer sortid;
    private Integer typeid;
    private String typename;
    private String sortname;
}
