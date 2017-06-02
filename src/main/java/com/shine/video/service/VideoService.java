package com.shine.video.service;

import com.shine.video.dao.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by 7le on 2017/5/21 0021.
 */
public interface VideoService {

    /**
     * 列表页
     * @param name
     * @return
     */
    List<Video> page(String name);

    /**
     * 查询单个
     * @param vid
     * @return
     */
    Video selectOne(Integer vid);

    /**
     * 上传
     * @param file
     */
    void upload(Integer id, MultipartFile file,String name) throws Exception;

    /**
     * 上传
     * @param file
     */
    void transCode(Integer id, MultipartFile file) throws Exception;

    /**
     * 删除
     */
    void delete(Integer vid) throws Exception;
}
