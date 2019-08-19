package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.Bought;

import java.util.List;

public interface IBoughtService {
    //查询所有交易
    List<Bought> getAllBought();
    //根据uid查用户名
    String getUserNameByUid(Integer uid);
    //根据交易ID删除交易
    void removeBought(Integer bid);
}
