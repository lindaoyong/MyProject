package com.example.microservice.controller;

import com.example.microservice.entity.User;
import com.example.microservice.security.WebSecurityConfig;
import com.example.microservice.service.IHibernateJpaService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
public class WebController {
    private static final Logger logger = Logger.getLogger(WebController.class);
    @Autowired
    IHibernateJpaService iService;

    @GetMapping(value = "/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model){
        model.addAttribute("name", account);
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/loginPost")
    public @ResponseBody
    Map<String, Object> loginPost(String account, String password, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        logger.info("用户账号："+account+"，用户密码："+password);
        User user = iService.testHibernateJpaTransaction(account,password);
        if (user==null) {
            map.put("success", false);
            map.put("message", "密码错误");
            return map;
        }

        // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, account);

        map.put("success", true);
        map.put("message", user.getUserName()+",恭喜你登录成功！");
        return map;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        logger.info("已经清除的session："+session.getId());
        return "redirect:/login";
    }
}
