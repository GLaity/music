package com.lanqiao.music.server.service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMusicService {
    List<Music> getAllMusic();

    void addMusic(Music music);
}
