package com.shine.video.dao;


import com.shine.video.dao.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 检索数量通过用户名
     *
     * @param username 用户名
     */

    int selectCountByUsername(String username);

    /**
     * 根据用户名查找管理员
     */
    User selectByUsername(String username);
}