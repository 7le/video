package com.shine.video.service.impl;

import com.shine.video.bean.Constant;
import com.shine.video.bean.Page2;
import com.shine.video.dao.model.Collect;
import com.shine.video.service.CollectService;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 7le on 2017/5/21 0021.
 */
@Service
public class CollectServiceImpl extends BaseServiceImpl implements CollectService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void collect(Integer userId, Integer videoId) {

        if(collectMapper.selectByUidAndVid(userId,videoId)!=null){
            throw new HttpMessageNotReadableException("该视频已经收藏");
        }

        Collect collect=new Collect();
        collect.setUid(userId);
        collect.setVid(videoId);
        collect.setDeleteFlag(Constant.NO_DELETE);
        collect.setCreatedAt(new Date());
        collectMapper.insert(collect);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer userId, Integer videoId) {
        Collect collect=collectMapper.selectByUidAndVid(userId,videoId);
        collect.setDeleteFlag(Constant.DELETE);
        collectMapper.updateByPrimaryKeySelective(collect);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Collect> page(Integer userId) {
        return collectMapper.page(userId);
    }

}
