package com.lanqiao.music.server.frontservice.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.AdviceMapper;
import com.lanqiao.music.server.frontservice.IAdviceService;
import com.lanqiao.music.server.pojo.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service
@Component
public class AdviceService implements IAdviceService {

    @Autowired
    private AdviceMapper adviceMapper;


    @Override
    public Integer addAdvice(Advice advice) {
        return adviceMapper.insertAdvice(advice);
    }

    @Override
    public Advice findAdviceByAid(Integer aid) {
        return findAdviceByAid(aid);
    }

    @Override
    public List<Advice> findAdviceByMusic(Integer mid) {
        return findAdviceByMusic(mid);
    }

    @Override
    public List<Advice> findAdviceByUser(Integer uid) {
        return findAdviceByUser(uid);
    }
}
