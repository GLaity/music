package com.lanqiao.music.server.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Data
@Component
//购买记录表
public class Bought  implements Serializable {
//    单号id
    private Integer bid;
//    用户id
    private Integer uid;
//    服务类型（充值消费买会员）
    private String service;
//    购买时间
    private Date bdate;
//    交易金额
    private Double bmoney;
}
