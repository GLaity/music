package com.lanqiao.music.server.service;
import com.lanqiao.music.server.pojo.Music;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMusicService {
    List<Music> queryAllMusic();
    Music queryMusicByMId(Integer mid);
}
