package com.shine.video.util;

import java.io.*;
import java.util.List;

/**
 * Created by 7le on 2017/5/24 0024.
 */
public class VideoUtil {

    public static String processImgLinux(String video_path,String ffmpeg_path) throws Exception {

        File file = new File(video_path);
        if (!file.exists()) {
            throw new Exception("路径[" + video_path + "]对应的视频文件不存在!");
        }
        String imgName=System.currentTimeMillis()+".jpg";
        List<String> commands = new java.util.ArrayList<String>();
        commands.add(ffmpeg_path);
        commands.add("-i");
        commands.add(video_path);
        commands.add("-y");
        commands.add("-f");
        commands.add("image2");
        commands.add("-ss");
        commands.add("1");//这个参数是设置截取视频多少秒时的画面
        //commands.add("-t");
        //commands.add("0.001");
        commands.add("-s");
        commands.add("800x600");
        commands.add("/software/video/img/"+imgName);
        StringBuffer test=new StringBuffer();
        for(int i=0;i<commands.size();i++)
            test.append(commands.get(i)+" ");
        System.out.println(test);
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(test.toString());
            InputStream stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ( (line = br.readLine()) != null);

        } catch (IOException e) {
            throw new Exception("截图图片失败");
        }
        return imgName;
    }

    /**
     * Linux 转码
     * @param video_path 视频路径
     * @param ffmpeg_path ffmpeg路径
     * @param type  要转换的类型
     * @return ./ffmpeg -i /opt/spzh/yysp.avi -f mp4 -acodec libfaac -vcodec libxvid -qscale 7 -dts_delta_threshold 1 -y /opt/spzh/out/yysp8.mp4
     * @throws Exception
     */
    public static String transcodingByLinux(String video_path, String ffmpeg_path, String type) throws Exception {
        File file = new File(video_path);
        if (!file.exists()) {
            throw new Exception("路径[" + video_path + "]对应的视频文件不存在!");
        }
        String videoName=System.currentTimeMillis()+"."+type;
        List<String> commands = new java.util.ArrayList<String>();
        commands.add(ffmpeg_path);
        commands.add("-i");
        commands.add(video_path);
        commands.add("-f");
        commands.add("mp4");
        commands.add("-acodec");
        commands.add("libfaac");
        commands.add("-vcodec");
        commands.add("libxvid");
        commands.add("-qscale");
        commands.add("7");
        commands.add("-dts_delta_threshold");
        commands.add("-y");
        commands.add("/software/video/"+videoName);
        StringBuffer test=new StringBuffer();
        for(int i=0;i<commands.size();i++)
            test.append(commands.get(i)+" ");
        System.out.println(test);
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(test.toString());
            InputStream stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ( (line = br.readLine()) != null);

        } catch (IOException e) {
            throw new Exception("截图图片失败");
        }
        return videoName;
    }


    //截取视频第一帧windows
    public static boolean processImgWindows(String video_path,String ffmpeg_path) {
        File file = new File(video_path);
        if (!file.exists()) {
            System.err.println("路径[" + video_path + "]对应的视频文件不存在!");
            return false;
        }
        String imgName=System.currentTimeMillis()+".jpg";
        List<String> commands = new java.util.ArrayList<String>();
        commands.add(ffmpeg_path);
        commands.add("-i");
        commands.add(video_path);
        commands.add("-y");
        commands.add("-f");
        commands.add("image2");
        commands.add("-ss");
        commands.add("1");//这个参数是设置截取视频多少秒时的画面
        //commands.add("-t");
        //commands.add("0.001");
        commands.add("-s");
        commands.add("800x600");
        commands.add("/software/video/"+imgName);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            builder.start();
            System.out.println("截取成功");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
