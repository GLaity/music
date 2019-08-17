package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.SheetMapper;
import com.lanqiao.music.server.pojo.*;
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
    public void initSheet(Sheet sheet,User user,Integer type) {
        if (sheet.getMusicList().size()==0){
            sheetMapper.insertSheet(sheet);
            sheetMapper.insertSheetUser(sheet.getSid(),user.getUid(),sheet.getSname(),type);
        }else {
            List<Music> musicList=sheet.getMusicList();
            for (Music music :musicList){
               sheetMapper.insertSheetMusic(sheet.getSid(),music.getMid());
            }
        }
    }


    @Override
    public void deletSheet(User user,Sheet sheet) {
       sheetMapper.deleteSheetUser(user.getUid());
       sheetMapper.deleteSheet(sheet.getSname());
        List<Music> musicList=sheet.getMusicList();
        for (Music music:musicList){
            sheetMapper.deleteSheetMusic(sheet.getSid(),music.getMid());
        }
    }

    @Override
    public List<Sheet> seach(User user) {
        return  sheetMapper.searchByUser(user.getUname());
    }

    @Override
    public List<Sheet> seachByCondition(String sname, int ssum, String scontext) {
        return sheetMapper.searchByCondition(sname,ssum,scontext);
    }

    @Override
    public List<Sheet> seachByNum(int minSum, int maxSum) {
        return sheetMapper.searchBySum(minSum,maxSum);
    }

    @Override
    public List<Sheet> searchByMusic(String mname) {
        return sheetMapper.searchByMusic(mname);
    }

    @Override
    public List<Sheet> searchAll() {
        return sheetMapper.searchAll();
    }

    @Override
    public List<Sheet> searchBytype(Integer type) {
        return sheetMapper.searchBytype(type);
    }
}
