package com.lanqiao.music.server.frontservice.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.MusicMapper;
import com.lanqiao.music.server.frontservice.IMusicService;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
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
    public List<Music> queryMusicByLikename(String likeName) {
        return musicMapper.selectMusicByLikeName(likeName);
    }

    @Override
    public List<Music> queryMusicByCondition(String mname, String msinger, Integer mlevel, String mtheme, String mstyle, String mlanguage, Integer mprice) {
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
    @Override
    public List<Music> queryMusicCondition(Integer type,Integer sortid) {
        List<Music> musicList = new ArrayList<>();
//        System.out.println(musicMapper.selectBySortId(1).getSortname());
        switch (type){
            case 3:
                musicList = musicMapper.selectMusicByCondition(null,null,null,musicMapper.selectBySortId(sortid).getSortname(),null,null,null);
                break;
            case 2:
                musicList = musicMapper.selectMusicByCondition(null,null,null,null,musicMapper.selectBySortId(sortid).getSortname(),null,null);
                break;
            case 1:
                musicList = musicMapper.selectMusicByCondition(null,null,null,null,null,musicMapper.selectBySortId(sortid).getSortname(),null);
                break;
        }
//        System.out.println(musicList.size());
        return musicList;
    }
}
