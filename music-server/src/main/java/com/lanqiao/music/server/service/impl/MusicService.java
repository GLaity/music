package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.MusicMapper;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sort;
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

    @Override
    public List<Music> queryMusicByCondition(String mname, String msinger, Integer mlevel, Integer mtheme, Integer mstyle, Integer mlanguage, Integer mprice) {
        return musicMapper.selectMusicByCondition(mname, msinger, mlevel, mtheme, mstyle, mlanguage, mprice);
    }

    @Override
    public List<Sort> queryTheme() {
        return musicMapper.selectSortByType(3);
    }

    @Override
    public List<Sort> queryStyle() {
        return musicMapper.selectSortByType(2);
    }

    @Override
    public List<Sort> queryLanguage() {
        return musicMapper.selectSortByType(1);
    }
}
