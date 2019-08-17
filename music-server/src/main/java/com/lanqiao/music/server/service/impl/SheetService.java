package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.SheetMapper;
import com.lanqiao.music.server.pojo.*;
import com.lanqiao.music.server.service.ISheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Service
public class SheetService implements ISheetService {
    private SheetMapper sheetMapper;
    @Override
    public void initSheet(Sheet sheet, User user, Integer type) {
    sheetMapper.insertSheetUser(sheet.getSid(),user.getUid(),sheet.getSname(),type);
    }

    @Override
    public void deletSheet(User user, Sheet sheet) {
    sheetMapper.deleteSheetMusic(sheet.getSid(),user.getUid());
    sheetMapper.deleteSheetUser(user.getUid());
    sheetMapper.deleteByPrimaryKey(sheet.getSid());
    }

    @Override
    public List<Sheet> seach(User user) {
        return sheetMapper.searchByUser(user.getUid());
    }

    @Override
    public List<Sheet> seachByCondition(String sname, int ssum, String scontext) {
        return null;
    }

    @Override
    public List<Sheet> seachByNum(int minSum, int maxSum) {
        return null;
    }

    @Override
    public List<Sheet> searchByMusic(String mname) {
        return null;
    }

    @Override
    public List<Sheet> searchAll() {
        return null;
    }

    @Override
    public List<Sheet> searchBytype(Integer type) {
        return null;
    }
}
