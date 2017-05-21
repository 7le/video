package com.shine.video.service;

import com.shine.video.bean.Page2;
import com.shine.video.dao.model.Collect;

import java.util.List;

/**
 * Created by 7le on 2017/5/21 0021.
 */
public interface CollectService {

    /**
     * 收藏视频接口
     */
    void collect(Integer userId,Integer videoId);

    /**
     * 删除收藏
     */
    void delete(Integer userId,Integer videoId);

    /**
     * 收藏列表分页
     */
    List<Collect> page(Integer userId);
}
