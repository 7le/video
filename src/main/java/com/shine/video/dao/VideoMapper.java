package com.shine.video.dao;

import com.shine.video.dao.model.Video;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VideoMapper {
    int deleteByPrimaryKey(Integer vid);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer vid);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
}