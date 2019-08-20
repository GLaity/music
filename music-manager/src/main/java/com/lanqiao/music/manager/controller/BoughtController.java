package com.lanqiao.music.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanqiao.music.server.pojo.Bought;
import com.lanqiao.music.server.service.IBoughtService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@EnableAutoConfiguration
@RequestMapping("/bought")
public class BoughtController {

    @Reference
    private IBoughtService boughtService;

    @RequestMapping("/list.do")
    public String boughtList(ModelMap map){
//        PageHelper.startPage(pageNum,10);
        List<Bought> boughtList = boughtService.getAllBought();
//        PageInfo<Bought> page = new PageInfo<>(boughtList);

        for (Bought bought : boughtList){
            String user = boughtService.getUserNameByUid(bought.getUid());
            bought.setUser(user);
        }
//        String size = String.valueOf(boughtList.size());
//        map.addAttribute("page",page);
        map.addAttribute("size",boughtList.size());
        map.addAttribute("boughtList",boughtList);
        return "buy-list";
    }

    @ResponseBody
    @GetMapping("/delete.do/{bid}")
    public Object deleteMusic(@PathVariable Integer bid){
        Map<String,Object> map = new HashMap<>();
        boughtService.removeBought(bid);
        List<Bought> boughtList = boughtService.getAllBought();
        map.put("count",boughtList.size());
        map.put("msg","删除成功！");
        return map;
    }

}
