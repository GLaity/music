package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.Advice;

import java.util.List;

public interface IAdviceService {
    //查询所有评论
    List<Advice> getAllAdvice();
    //根据uid查用户名
    String getUserNameByUid(Integer uid);
    //根据mid查歌曲名
    String getMusicNameByMid(Integer mid);
    //根据评论ID删除评论
    void removeAdvice(Integer aid);

}
