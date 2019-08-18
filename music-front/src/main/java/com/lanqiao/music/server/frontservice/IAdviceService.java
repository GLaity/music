package com.lanqiao.music.server.frontservice;

import com.lanqiao.music.server.pojo.Advice;

import java.util.List;

public interface IAdviceService {
    Integer addAdvice(Advice advice);
    Advice findAdviceByAid(Integer aid);
    List<Advice> findAdviceByMusic(Integer mid);
    List<Advice> findAdviceByUser(Integer uid);
}
