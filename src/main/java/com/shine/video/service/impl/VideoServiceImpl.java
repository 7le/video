package com.shine.video.service.impl;

import com.shine.video.bean.Constant;
import com.shine.video.dao.model.Video;
import com.shine.video.service.VideoService;
import com.shine.video.util.VideoUtil;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by 7le on 2017/5/21 0021.
 */
@Service
public class VideoServiceImpl extends BaseServiceImpl implements VideoService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<Video> page(String name) {
        return videoMapper.page(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Video selectOne(Integer vid) {
        return videoMapper.selectByPrimaryKey(vid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void upload(Integer id, MultipartFile file, String videoName) throws Exception{

        if(file==null){
            throw new HttpMessageNotReadableException("文件为空");
        }
        String[] str=file.getOriginalFilename().split("\\.");
        //暂时只支持mp4格式
        if(!"mp4".equals(str[str.length-1]) && !"MP4".equals(str[str.length-1])){
            throw new HttpMessageNotReadableException("暂时只支持mp4格式");
        }
        String name=System.currentTimeMillis()+"."+str[str.length-1];
        BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(new File("/software/video/"+name)));
        out.write(file.getBytes());
        out.flush();
        out.close();

        String photoUrl=VideoUtil.processImgLinux("/software/video/"+name,"/usr/local/ffmpeg/bin/./ffmpeg");
        //路径在linux下再配置
        String filename="http://7le.online/"+name;
        Video video=new Video();
        video.setDeleteFlag(Constant.NO_DELETE);
        video.setCreatedAt(new Date());
        video.setName(videoName);
        video.setCreator(id.toString());
        video.setPhotoUrl("http://7le.online/img/"+photoUrl);
        video.setVideoUrl(filename);
        videoMapper.insert(video);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transCode(Integer id, MultipartFile file) throws Exception {
        if(file==null){
            throw new HttpMessageNotReadableException("文件为空");
        }
        String[] str=file.getOriginalFilename().split("\\.");
        String name=System.currentTimeMillis()+"."+str[str.length-1];
        BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(new File("/software/video/"+name)));
        out.write(file.getBytes());
        out.flush();
        out.close();
        //不是mp4格式就转码
        if(!"mp4".equals(str[str.length-1]) && !"MP4".equals(str[str.length-1])){
            VideoUtil.transcodingByLinux("/software/video/"+name,"/usr/local/ffmpeg/bin/./ffmpeg","mp4");
        }

        String photoUrl=VideoUtil.processImgLinux("/software/video/"+name,"/usr/local/ffmpeg/bin/./ffmpeg");
        //路径在linux下再配置
        String filename="http://7le.online/"+name;
        Video video=new Video();
        video.setDeleteFlag(Constant.NO_DELETE);
        video.setCreatedAt(new Date());
        video.setName(str[0]);
        video.setCreator(id.toString());
        video.setPhotoUrl("http://7le.online/img/"+photoUrl);
        video.setVideoUrl(filename);
        videoMapper.insert(video);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer vid) throws Exception {
        videoMapper.delete(vid);
    }
}
