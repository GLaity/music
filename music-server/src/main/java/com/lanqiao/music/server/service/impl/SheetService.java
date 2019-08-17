package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.SheetMapper;
import com.lanqiao.music.server.pojo.Sheet;
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
    public List<Sheet> searchAll(String sname) {
        return sheetMapper.searchAll(sname);
    }
}
