package com.shine.video.service.impl;

import com.shine.video.dao.model.User;
import com.shine.video.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 7le on 2017/5/21 0021.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Override
    public List<User> page(Integer uid) {
        return userMapper.page(uid.toString());
    }

    @Override
    public void delete(Integer deleteId) {
        userMapper.delete(deleteId);
    }
}
