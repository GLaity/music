package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.AdviceMapper;
import com.lanqiao.music.server.pojo.Advice;
import com.lanqiao.music.server.service.IAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class AdviceService implements IAdviceService {

    @Autowired
    private AdviceMapper adviceMapper;

    @Override
    public List<Advice> getAllAdvice() {
        List<Advice> adviceList = adviceMapper.selectAllAdvice();
        return adviceList;
    }

    @Override
    public String getUserNameByUid(Integer uid) {
        return adviceMapper.selectUserNameByUid(uid);
    }

    @Override
    public String getMusicNameByMid(Integer mid) {
        return adviceMapper.selectMusicNameByMid(mid);
    }

    @Override
    public void removeAdvice(Integer aid) {
        adviceMapper.deleteAdvice(aid);
    }
}
