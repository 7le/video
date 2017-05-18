package com.shine.video.web;

import com.shine.video.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 总控制器
 * Created by 7le on 2017/5/18 0018.
 */
public class BaseController {

    protected static final Logger videoLogger = Logger.getLogger("video");

    //业务层
    @Autowired
    protected LoginService loginService;
}
