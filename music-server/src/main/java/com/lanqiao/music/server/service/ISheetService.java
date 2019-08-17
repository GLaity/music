package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.pojo.User;

import java.util.List;

public interface ISheetService {
    List<Sheet> searchAll();
    int searchId(String sname);
    void initSheet(Sheet sheet,User user ,Integer type);
    public Sheet updateSheet(Sheet sheet);
}
