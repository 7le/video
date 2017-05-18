package com.shine.video.web;


import com.shine.video.bean.ResultBean;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 7le on 2017/4/3.
 */
@RestController
public class LoginController extends BaseController{

    /**
     * 登录
     */
    @RequestMapping(value = "login" , method= RequestMethod.POST)
    @ApiOperation(value="登录接口", httpMethod = "POST" , notes="登录接口")
    public ResultBean login(HttpServletRequest request,HttpServletResponse response,
                            @ApiParam(required = true, name = "username", value = "用户名") @RequestParam String username,
                            @ApiParam(required = true, name = "password", value = "密码") @RequestParam String password ) {

        String error=loginService.doLogin(username,password,request);
        if(error==null){
            response.setStatus(response.SC_OK);
            return ResultBean.SUCCESS;
        }else {
            response.setStatus(response.SC_BAD_REQUEST);
            return ResultBean.error(error);
        }
    }

    /**
     * 注册
     * @param request
     * @return
     */
    @RequestMapping(value ="register" , method= RequestMethod.POST)
    @ApiOperation(value="注册接口", httpMethod = "POST" , notes="注册接口")
    public ResultBean register(HttpServletRequest request,HttpServletResponse response,
                           @ApiParam(required = true, name = "username", value = "用户名") @RequestParam String username,
                           @ApiParam(required = true, name = "password", value = "密码") @RequestParam String password) {
        String error=loginService.doRegister(username,password,request);
        if(error==null){
            response.setStatus(response.SC_OK);
            return ResultBean.SUCCESS;
        }else {
            response.setStatus(response.SC_BAD_REQUEST);
            return ResultBean.error(error);
        }
    }


}
