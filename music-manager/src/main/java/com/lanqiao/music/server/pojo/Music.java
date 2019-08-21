package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

@Data
@Component
public class Music  implements Serializable {
    //音乐ID
    private Integer mid;
    //歌名
    private String mname;
    //歌手
    private String msinger;
    //音乐简介
    private String mcontext;
    //专辑名
    private String malbum;
    //歌曲等级
    private Integer mlevel;
    //主题
    private String mtheme;
    //流派
    private String mstyle;
    //语种
    private String  mlanguage;
    //音乐价格
    private Double mprice;
    //音乐路径
    private String mloc;
    //发行时间
    private Date mdate;

    private MultipartFile img1;

    private MultipartFile img2;

    private MultipartFile img3;
}
