package com.lanqiao.music.server.service;
import com.lanqiao.music.server.pojo.Music;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IMusicService {
    //查询所有音乐
    List<Music> getAllMusic();
    //查询一首音乐
    Music getOneMusic(Integer mid);
    //添加音乐
    void addMusic(Music music);
    //根据音乐ID删除音乐
    void removeMusic(Integer mid);
    //删除与已删音乐有关的记录
    void removeRadioMusic(Integer mid);
    void removeSheetMusic(Integer mid);
    //更新音乐
    void modifyMusic(Music music);
}
