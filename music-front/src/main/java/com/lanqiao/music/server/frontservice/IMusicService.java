package com.lanqiao.music.server.frontservice;
import com.lanqiao.music.server.pojo.Music;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IMusicService {
    List<Music> queryAllMusic();
    Music queryMusicByMId(Integer mid);
}
