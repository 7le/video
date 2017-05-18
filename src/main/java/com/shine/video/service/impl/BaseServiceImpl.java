package com.shine.video.service.impl;

import com.shine.video.dao.CollectMapper;
import com.shine.video.dao.UserMapper;
import com.shine.video.dao.VideoMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 7le on 2017/5/17 0017.
 */
public class BaseServiceImpl {

    protected static final Logger videoLogger = Logger.getLogger("video");

    @Autowired
    protected CollectMapper collectMapper;

    @Autowired
    protected UserMapper userMapper;

    @Autowired
    protected VideoMapper videoMapper;
}
