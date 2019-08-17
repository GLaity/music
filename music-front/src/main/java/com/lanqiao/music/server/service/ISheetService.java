package com.lanqiao.music.server.service;

import com.lanqiao.music.server.pojo.Sheet;

import java.util.List;

public interface ISheetService {
    List<Sheet> searchAll(String sname);
}
