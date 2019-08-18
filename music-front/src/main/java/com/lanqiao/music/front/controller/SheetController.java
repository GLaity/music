package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.Sheet;
import com.lanqiao.music.server.service.ISheetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SheetController {
    @Reference
    private ISheetService iSheetService;
    @RequestMapping("/iframeplay-list")
    public String iframeplaylist(ModelMap map){
        List<Sheet> sheetList=iSheetService.findAllSheet();
        map.addAttribute("sheets",sheetList);
        return "play-list";
    }
    @RequestMapping("/playlistenter")
    public String Iplaylistenter()
    {
        return "play-list-enter";
    }

}
