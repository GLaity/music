package com.lanqiao.music.server.frontservice.impl;

import com.lanqiao.music.server.dao.MusicMapper;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.frontservice.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;

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
