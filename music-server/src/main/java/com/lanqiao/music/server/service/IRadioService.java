package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Radio;

import java.util.List;

public interface IRadioService {
    //查询所有电台
    List<Radio> getAllRadio();
    //查询某个电台中的所有歌曲
    List<Music> getMusicByRid(Integer rid);
    //按条件搜索
    List<Radio> findRadioByAttr(String attr,String key);

}
