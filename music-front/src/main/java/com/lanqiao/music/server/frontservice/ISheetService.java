package com.lanqiao.music.server.frontservice;

import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;

import java.util.List;

public interface ISheetService {
    //初始化收藏歌曲和购买歌曲
    void addInitSheet(Integer uid);
    //自创歌单
    void addMySheet(Sheet sheet);
    //收藏别人歌单
    void addOtherSheet(Integer uid, Integer sid);
    //取消收藏别人歌单
    void removeOtherSheet(Integer uid, Integer sid);
    //修改自创歌单
    void modifySheet(Sheet sheet);
    //歌单中添加歌曲
    void addMusicIntoSheet(Integer mid, Integer sid);
    //歌单中删除歌曲
    void removeMusicFromSheet(Integer mid, Integer sid);
    //查询单个歌单
    Sheet findSheetBySid(Integer sid);
    //查询自己的收藏歌曲
    List<Music> findMyCollectedMusic(Integer uid);
    //查询自己的购买歌曲
    List<Music> findMyBoughtMusic(Integer uid);
    //查询自己的自创歌单
    List<Sheet> fingMyCreatSheet(Integer uid);
    //查询自己的收藏歌单
    List<Sheet> fingMyCollectionSheet(Integer uid);
    //查询所有歌单
    List<Sheet> findAllSheet();
    //查询所有共有歌单
    List<Sheet>findAllPublicSheet();
    //根据歌单id查看uid
    Integer findUser(Integer sid);
    //根据歌单id查找作者
    Integer getAuthorId(Integer sid);
}
