package com.lanqiao.music.server.dao;


import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Radio;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RadioMapper {
    //查询所有电台
    List<Radio> selectAllRadio();
    //查询某个电台中的所有歌曲
    List<Music> selectMusicByRid(Integer rid);
    //按条件搜索
    List<Radio> selectRadioByAttr(String attr,Object key);

}
