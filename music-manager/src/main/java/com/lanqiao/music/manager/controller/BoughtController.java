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

import java.util.List;

@Controller
@EnableAutoConfiguration
@RequestMapping("/bought")
public class BoughtController {

    @Reference
    private IBoughtService boughtService;

    @RequestMapping(value = "/list.do/{pageNum}",method = RequestMethod.GET)
    public String boughtList(ModelMap map,@RequestParam(value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Bought> boughtList = boughtService.getAllBought();
        PageInfo<Bought> page = new PageInfo<>(boughtList);

        for (Bought bought : boughtList){
            String user = boughtService.getUserNameByUid(bought.getUid());
            bought.setUser(user);
        }
        String size = String.valueOf(boughtList.size());
        map.addAttribute("page",page);
        map.addAttribute("size",size);
        map.addAttribute("boughtList",boughtList);
        return "buy-list";
    }

    @GetMapping("/delete.do/{bid}")
    public Object deleteMusic(@PathVariable Integer bid){
        boughtService.removeBought(bid);
        return "redirect:/bought/list.do";
    }

}
