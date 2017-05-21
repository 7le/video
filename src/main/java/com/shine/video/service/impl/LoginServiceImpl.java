package com.shine.video.service.impl;

import com.shine.video.bean.Constant;
import com.shine.video.dao.model.User;
import com.shine.video.service.LoginService;
import com.shine.video.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 7le on 2017/5/17 0017.
 */
@Service
public class LoginServiceImpl  extends BaseServiceImpl implements LoginService{

    @Override
    public void doRegister(String username, String password, HttpServletRequest request) {
        if (username == null) {
            throw new HttpMessageNotReadableException("请输入用户名");
        }

        if (password == null || password.length() == 0) {
            throw new HttpMessageNotReadableException("请输入密码");
        }

        //检查账号是否被注册
        if (userMapper.selectCountByUsername(username) > 0) {
            throw new HttpMessageNotReadableException("该账号已经被注册");
        }

        //添加用户信息
        User user=new User();
        user.setType(Constant.USER_TYPE_ORDINARY);
        user.setCreatedAt(new Date());
        user.setCreator(request.getAttribute("name").toString());
        user.setModifier(request.getAttribute("name").toString());
        user.setDeleteFlag(Constant.NO_DELETE);
        user.setUsername(username);
        user.setPassword(MD5Util.doImaoMd5(username,password));
        userMapper.insert(user);
    }

    @Override
    public void doLogin(String username, String password, HttpServletRequest request) {
        User user=userMapper.selectByUsername(username);

        if (user == null) {
            throw new HttpMessageNotReadableException("用户名不存在");
        }

        if (password == null || password.length() == 0) {
            throw new HttpMessageNotReadableException("请输入密码");
        }
        if (!user.getPassword().equals(MD5Util.doImaoMd5(user.getUsername(), password))) {
            throw new HttpMessageNotReadableException("账号或密码错误");
        }
    }
}
