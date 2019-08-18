package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.service.IMusicService;
import com.lanqiao.music.server.dao.MusicMapper;
import com.lanqiao.music.server.pojo.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class MusicService implements IMusicService {
    @Autowired
    private MusicMapper musicMapper;
    @Override
    public List<Music> getAllMusic() {
        List<Music> musicList = musicMapper.selectMusicAll();
        return musicList;
    }

    @Override
    public void addMusic(Music music) {
        musicMapper.insertMusic(music);
    }

    @Override
    public void removeMusic(Integer mid) {
        musicMapper.deleteMusicByMId(mid);
    }

    @Override
    public void removeRadioMusic(Integer mid) {
        musicMapper.deleteRadioMusic(mid);
    }

    @Override
    public void removeSheetMusic(Integer mid) {
        musicMapper.deleteSheetMusic(mid);
    }

    @Override
    public Music getOneMusic(Integer mid) {
        Music music = musicMapper.selectOneMusic(mid);
        return music;
    }

    @Override
    public void modifyMusic(Music music) {
        musicMapper.updateMusic(music);
    }
}
