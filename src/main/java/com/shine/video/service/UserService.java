package com.shine.video.service;

import com.shine.video.dao.model.User;

import java.util.List;

/**
 * Created by 7le on 2017/5/21 0021.
 */
public interface UserService {

    List<User> page(Integer uid);

    void delete(Integer deleteId);
}
