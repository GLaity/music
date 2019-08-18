package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.BoughtMapper;
import com.lanqiao.music.server.pojo.Bought;
import com.lanqiao.music.server.service.IBoughtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class BoughtService implements IBoughtService {
    @Autowired
    private BoughtMapper boughtMapper;
    @Override
    public List<Bought> getAllBought() {
        return boughtMapper.selectAllBought();
    }

    @Override
    public String getUserNameByUid(Integer uid) {
        return boughtMapper.selectUserNameByUid(uid);
    }

    @Override
    public void removeBought(Integer bid) {
        boughtMapper.deleteBought(bid);
    }
}
