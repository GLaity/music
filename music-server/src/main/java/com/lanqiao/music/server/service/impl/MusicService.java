package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.MusicMapper;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class MusicService implements IMusicService {
    @Autowired
    private MusicMapper musicMapper;

    @Override
    public List<Music> queryAllMusic() {
        return musicMapper.selectMusicAll();
    }

    @Override
    public Music queryMusicByMId(Integer mid) {
        return musicMapper.selectMusicByMId(mid);
    }
}
