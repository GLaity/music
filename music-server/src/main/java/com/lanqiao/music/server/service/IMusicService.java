package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.Music;

import java.util.List;

public interface IMusicService {

    List<Music> getAllMusic();

    void addMusic(Music music);
}
