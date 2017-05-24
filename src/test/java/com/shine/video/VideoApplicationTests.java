package com.shine.video;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.shine.video.dao.CollectMapper;
import com.shine.video.dao.UserMapper;
import com.shine.video.dao.model.User;
import com.shine.video.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void process(){
		processImg("C:/Users/Administrator/Desktop/xka.mp4",System.getProperty("user.dir")+"/ffmpeg.exe");
	}

	public static boolean processImg(String video_path,String ffmpeg_path) {
		File file = new File(video_path);
		if (!file.exists()) {
			System.err.println("路径[" + video_path + "]对应的视频文件不存在!");
			return false;
		}
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
		System.out.println(video_path.substring(0, video_path.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg");
		commands.add(video_path.substring(0, video_path.lastIndexOf(".")).replaceFirst("vedio", "file") + ".jpg");
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

	@Test
	public void StringTest(){
		String str="cat.mp4";
		String[] name=str.split("\\.");

		System.out.println(name[name.length-1]);

		System.out.println(MD5Util.doImaoMd5("root","youziyouzi"));
	}

	@Test
	public void contextLoads() {
		User user=new User();
		user.setUsername("1");
		user.setType(1);
		user.setName("1");
		user.setCreatedAt(new Date());
		user.setCreator("1");
		user.setDeleteFlag(1);
		user.setModifier("1");
		user.setPassword("1");
		userMapper.insert(user);
	}

	@Test
	public void guavaStrings() {
		//判断字符串是否为空
		String input = "";
		boolean isNullOrEmpty = Strings.isNullOrEmpty(input);
		System.out.println("input " + (isNullOrEmpty?"is":"is not") + " null or empty.");

		//获得两个字符串相同的前缀或者后缀
		String a = "com.jd.coo.Hello";
		String b = "com.jd.coo.Hi";
		String ourCommonPrefix = Strings.commonPrefix(a,b);
		System.out.println("a,b common prefix is " + ourCommonPrefix);

		String c = "com.google.Hello";
		String d = "com.jd.Hello";
		String ourSuffix = Strings.commonSuffix(c,d);
		System.out.println("c,d common suffix is " + ourSuffix);

		//Strings的padStart和padEnd方法来补全字符串
		int minLength = 4;
		String padEndResult = Strings.padEnd("123", minLength, '0');
		System.out.println("padEndResult is " + padEndResult);

		String padStartResult = Strings.padStart("1", 4, '0');
		System.out.println("padStartResult is " + padStartResult);

		//使用Splitter类来拆分字符串
		Iterable<String> splitResults = Splitter.onPattern("[,，]{1,}")
				.trimResults()
				.omitEmptyStrings()
				.split("hello,word,,世界，水平");

		for (String item : splitResults) {
			System.out.println(item);
		}
		//二次拆分
		String toSplitString = "a=b;c=d,e=f";
		Map<String,String> kvs = Splitter.onPattern("[,;]{1,}").withKeyValueSeparator('=').split(toSplitString);
		for (Map.Entry<String,String> entry : kvs.entrySet()) {
			System.out.println(String.format("%s=%s", entry.getKey(),entry.getValue()));
		}

		//合并字符串
		String joinResult = Joiner.on(" ").join(new String[]{"hello","world"});
		System.out.println(joinResult);

		Map<String,String> map = new HashMap<String,String>();
		map.put("a", "b");
		map.put("c","d");
		String mapJoinResult = Joiner.on(",").withKeyValueSeparator("=").join(kvs);
		System.out.println(mapJoinResult);
	}

}
