package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"user"}, types = {User.class})
public class UserController {

    @Reference
    private IUserService iUserService;

    @RequestMapping("/")
    public String init(){
        return "login";
    }

    @RequestMapping("/login")
    public String loginCheck(String uname, String upwd, Model model){
        User user = iUserService.login(uname,upwd);
        if (user != null){
            model.addAttribute("user",user);
            return "index";
        } else {
            return "login";
        }
    }

    @RequestMapping("/money")
    public String rechargeMoney(@ModelAttribute("user") User user,Double money, Model model){
        System.out.println(user);
        iUserService.addBalance(user,money);
        model.addAttribute("user",user);
        model.addAttribute("msg","充值成功:"+money);
        return "index";
    }
    @RequestMapping("/vip")
    public String vip(@ModelAttribute("user") User user, Integer mouth, Model model){
        if(user.getUbalance()>=mouth*10.0){
            iUserService.rechargeVip(user, mouth);
            iUserService.reduceBalance(user,mouth*10.0);
            model.addAttribute("user",user);
            model.addAttribute("msg","充值会员成功");
            return "index";
        }else {
            model.addAttribute("msg","余额不足请充值");
            return "index";
        }
    }
}
