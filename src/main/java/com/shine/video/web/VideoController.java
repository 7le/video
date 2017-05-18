package com.shine.video.web;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 视频控制器
 * Created by 7le on 2017/4/3.
 */
@RestController
@RequestMapping("/video")
public class VideoController {

    @RequestMapping(value = "/show", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    // 这里指定RequestMethod，如果不指定Swagger会把所有RequestMethod都输出，在实际应用中，具体指定请求类型也使接口更为严谨。
    @ApiOperation(value="测试接口", notes="测试接口详细描述")
    public String show(@ApiParam(required=true, name="name", value="姓名")
                        @RequestParam(name = "name", required=true) String stuName){
        return "success";
    }
}