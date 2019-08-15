package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.Bought;

public interface IBoughtService {
    void addBought(Integer uid,String service,Double money);
}
