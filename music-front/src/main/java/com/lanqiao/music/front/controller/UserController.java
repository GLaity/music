package com.lanqiao.music.front.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lanqiao.music.server.pojo.User;
import com.lanqiao.music.server.service.IBoughtService;
import com.lanqiao.music.server.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes(value = {"user"}, types = {User.class})
public class UserController {

    @Reference
    private IUserService iUserService;
    @Reference
    private IBoughtService iBoughtService;

    @RequestMapping("/")
    public String init(){
        return "index";
    }

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/toregister")
    public String toregister(){
        return "register";
    }

    @RequestMapping("/topersonal")
    public String topersonal(){
        return "personal";
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
        iUserService.addBalance(user,money);
        iBoughtService.addBought(user.getUid(),"充值",money);
        model.addAttribute("user",user);
        model.addAttribute("msg","充值成功:"+money);
        return "index";
    }
    @RequestMapping("/vip")
    public String vip(@ModelAttribute("user") User user, Integer mouth, Model model){
        if(user.getUbalance()>=(mouth*10.0)){
            iUserService.rechargeVip(user, mouth);
            iBoughtService.addBought(user.getUid(),"充值会员",mouth*10.0);
            model.addAttribute("user",user);
            model.addAttribute("msg","充值会员成功");
            return "index";
        }else {
            model.addAttribute("msg","余额不足请充值");
            return "index";
        }
    }
    @RequestMapping("/check")
    @ResponseBody
    public String check(String username){
        User user = iUserService.findUserByName(username);
        String msg= "";
        if(user!=null){
            msg="0";
        }
        return msg;
    }
    @RequestMapping("/register")
    public String register(String username,String password){
        User user = new User();
        user.setUname(username);
        user.setUpwd(password);
        user.setUbalance(0.0);
        iUserService.register(user);
        return "login";
    }
    @RequestMapping("/out")
    public String out(HttpSession session){
            session.removeAttribute("user");
        return "login";
    }

}
