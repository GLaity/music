package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.SheetMapper;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.ISheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Service
public class SheetService implements ISheetService {
    @Autowired
    private SheetMapper sheetMapper;
    @Override
    public void addInitSheet(Integer uid) {
        Sheet sheet1 = new Sheet();
        sheet1.setScontext("默认收藏歌单");
        sheet1.setSname(uid.toString());
        sheet1.setSsum(0);
        sheet1.setType(0);
        sheet1.setUid(uid);
        Sheet sheet2 = new Sheet();
        sheet2.setScontext("默认购买歌单");
        sheet2.setSname(uid.toString());
        sheet2.setSsum(0);
        sheet2.setType(3);
        sheet2.setUid(uid);
        sheetMapper.insertSheet(sheet1);
        sheetMapper.insertSheet(sheet2);
    }

    @Override
    public void addMySheet(Sheet sheet) {
        sheet.setType(1);
        sheetMapper.insertSheet(sheet);
    }

    @Override
    public void addOtherSheet(Integer uid, Integer sid) {
        sheetMapper.insertSheetIntoUser(uid,sid);
    }

    @Override
    public void removeOtherSheet(Integer uid, Integer sid) {
        sheetMapper.deleteSheetFromUser(uid, sid);
    }

    @Override
    public void modifySheet(Sheet sheet) {
        sheetMapper.updateSheet(sheet);
    }

    @Override
    public void addMusicIntoSheet(Integer mid, Integer sid) {
        sheetMapper.insertMusicIntoSheet(mid, sid);
    }

    @Override
    public void removeMusicFromSheet(Integer mid, Integer sid) {
        sheetMapper.deleteMusicFormSheet(mid, sid);
    }

    @Override
    public Sheet findSheetBySid(Integer sid) {
        return sheetMapper.selectSheetBySid(sid);
    }

    @Override
    public List<Music> findMyCollectedMusic(Integer uid) {
        return sheetMapper.selectSheetByUserType(uid,0).get(0).getMusicList();
    }

    @Override
    public List<Music> findMyBoughtMusic(Integer uid) {
        return sheetMapper.selectSheetByUserType(uid,3).get(0).getMusicList();
    }

    @Override
    public List<Sheet> fingMyCreatSheet(Integer uid) {
        return sheetMapper.selectSheetByUserType(uid,1);
    }

    @Override
    public List<Sheet> fingMyCollectionSheet(Integer uid) {
        return sheetMapper.selectSheetByUserType(uid,2);
    }

    @Override
    public List<Sheet> findAllSheet() {
        return sheetMapper.selectAllSheet();
    }
}
