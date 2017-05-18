package com.shine.video.service.impl;

import com.shine.video.bean.Constant;
import com.shine.video.dao.model.User;
import com.shine.video.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 7le on 2017/5/17 0017.
 */
@Service
public class LoginServiceImpl  extends BaseServiceImpl implements LoginService{

    @Override
    public String doRegister(String username, String password, HttpServletRequest request) {
        if (username == null) {
            return "请输入用户名";
        }

        if (password == null || password.length() == 0) {
            return "请输入密码";
        }

        //检查账号是否被注册
        if (userMapper.selectCountByUsername(username) > 0) {
            return "该账号已经被注册";
        }

        //添加用户信息
        User user=new User();
        user.setType(Constant.USER_TYPE_ORDINARY);

        return null;
    }

    @Override
    public String doLogin(String username, String password, HttpServletRequest request) {
        return null;
    }
}
