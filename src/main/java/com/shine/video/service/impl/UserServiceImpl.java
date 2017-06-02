package com.shine.video.service.impl;

import com.shine.video.dao.model.User;
import com.shine.video.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 7le on 2017/5/21 0021.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<User> page(Integer uid) {
        return userMapper.page(uid.toString());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer deleteId) {
        userMapper.delete(deleteId);
    }
}
