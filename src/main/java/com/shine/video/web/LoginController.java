package com.shine.video.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 7le on 2017/4/3.
 */
@RestController
public class LoginController {

    /**
     * 登录
     */
    @RequestMapping(value = "login")
    public String login(HttpServletRequest request) {
        return "login";
    }

    /**
     * 注册
     * @param request
     * @return
     */
    @RequestMapping(value ="register")
    public String register(HttpServletRequest request) {
        return "register";
    }


}
