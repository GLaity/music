package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class Sort implements Serializable {
    private Integer sortid;
    private Integer typeid;
    private String typename;
    private String sortname;
}
