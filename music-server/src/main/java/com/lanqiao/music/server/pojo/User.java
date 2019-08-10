package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@Component
public class User {
    private Integer uid;
    private String uname;
    private String upwd;
    private Double ubalance;
    private Date udate;
    private Date vdate;
    private Integer usex;
    private String utel;
    //TODO
}
