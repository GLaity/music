package com.lanqiao.music.server.frontservice;

import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sort;

import java.util.List;


public interface IMusicService {
    List<Music> queryAllMusic();
    Music queryMusicByMId(Integer mid);
    List<Music> queryMusicByLikename(String likeName);
    List<Music> queryMusicByCondition(String mname,
                                      String msinger,
                                      Integer mlevel,
                                      Integer mtheme,
                                      Integer mstyle,
                                      Integer mlanguage,
                                      Integer mprice);
    List<Sort> queryTheme();
    List<Sort> queryStyle();
    List<Sort> queryLanguage();
}
