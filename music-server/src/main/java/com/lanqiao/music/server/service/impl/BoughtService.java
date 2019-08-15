package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.BoughtMapper;
import com.lanqiao.music.server.pojo.Bought;
import com.lanqiao.music.server.service.IBoughtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Service
public class BoughtService implements IBoughtService {
    @Autowired
    private BoughtMapper boughtMapper;
    @Override
    public void addBought(Integer uid,String service,Double money) {
        Bought bought = new Bought();
        bought.setUid(uid);
        bought.setService(service);
        bought.setBmoney(money);
        System.out.println(bought);
        boughtMapper.insertBought(bought);
    }
}
