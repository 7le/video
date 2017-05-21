package com.shine.video.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shine.video.bean.ResultBean;
import com.shine.video.dao.UserMapper;
import com.shine.video.dao.model.User;
import com.shine.video.redis.RedisUtil;
import com.shine.video.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token =request.getHeader("Authorization");
        //String token="ERR15zAv0B1PA64RfD9BTA==";
        if(token!=null){
            String id= EncryptUtil.aesDecrypt(token, EncryptUtil.KEY);
            User user=userMapper.selectByPrimaryKey(Integer.valueOf(id));
            String toke1=redisUtil.get(user.getUsername()).toString();
            if(token.equals(toke1)){
                request.setAttribute("token",token);
                request.setAttribute("type",user.getType());
                return true;
            }
        }

        ResultBean resultBean=ResultBean.error("token无效");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(JSON.toJSONString(resultBean));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

        return false;
    }


}
