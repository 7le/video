package com.shine.video.service.impl;

import com.shine.video.dao.model.Video;
import com.shine.video.service.VideoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 7le on 2017/5/21 0021.
 */
@Service
public class VideoServiceImpl extends BaseServiceImpl implements VideoService {
    @Override
    public List<Video> page() {
        return videoMapper.page();
    }
}
