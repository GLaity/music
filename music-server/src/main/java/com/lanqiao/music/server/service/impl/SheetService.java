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
    public List<Sheet> searchAll() {
        return sheetMapper.searchAll();
    }

    @Override
    public int searchId(String sname) {
        return sheetMapper.searchId(sname);
    }

    @Override
    public void initSheet(Sheet sheet,User user ,Integer type) {
//        List<Music>musicList=sheet.getMusicList();
        sheetMapper.insertSheet(sheet);
       Integer sid =sheetMapper.searchId(sheet.getSname());
       sheet.setSid(sid);
       sheetMapper.insertSheetUser(sheet.getSid(),user.getUid(),sheet.getSname(),type);
    }

    @Override
    public Sheet updateSheet(Sheet sheet) {
        return null;
    }
}
