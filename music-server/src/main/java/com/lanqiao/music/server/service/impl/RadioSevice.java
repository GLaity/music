package com.lanqiao.music.server.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanqiao.music.server.dao.RadioMapper;
import com.lanqiao.music.server.pojo.Music;
import com.lanqiao.music.server.pojo.Radio;
import com.lanqiao.music.server.service.IRadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service
public class RadioSevice implements IRadioService {

    @Autowired
    private RadioMapper radioMapper;

    @Override
    public List<Radio> getAllRadio() {
        return radioMapper.selectAllRadio();
    }

    @Override
    public List<Music> getMusicByRid(Integer rid) {
        return radioMapper.selectMusicByRid(rid);
    }

    @Override
    public List<Radio> findRadioByAttr(String attr,Object key) {
        return radioMapper.selectRadioByAttr(attr,key);
    }
}
