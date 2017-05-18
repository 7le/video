package com.shine.video.dao;


import com.shine.video.dao.model.Collect;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollectMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);
}