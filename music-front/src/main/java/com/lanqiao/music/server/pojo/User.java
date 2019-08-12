package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@Component
public class User {
//    用户编号(自增)
    private Integer uid;
//    用户名
    private String uname;
//    用户密码
    private String upwd;
//    账户余额
    private Double ubalance;
//    用户注册时间
    private Date udate;
//    会员到期时间
//    字段为空为非会员，每次登陆检查会员是否过期，过期则提示充值并清空字段
    private Date vdate;
//    用户性别(0为女，1为男)
    private Integer usex;
//
    private String utel;
    //TODO
}
