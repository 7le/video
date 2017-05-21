package com.shine.video.dao;


import com.shine.video.dao.model.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CollectMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Collect record);

    int insertSelective(Collect record);

    Collect selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    Collect selectByUidAndVid(@Param("uid") Integer uid,@Param("vid") Integer vid);

    List<Collect> page(@Param("uid") Integer uid);
}