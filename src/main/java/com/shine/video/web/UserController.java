package com.shine.video.web;

import com.github.pagehelper.PageHelper;
import com.shine.video.bean.Constant;
import com.shine.video.bean.ResultBean;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 7le on 2017/5/21 0021.
 */
@RestController
public class UserController extends BaseController {

    /**
     * 普通用户列表
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @ApiOperation(value="普通用户列表", httpMethod = "GET" , notes="普通用户列表")
    public ResultBean list(HttpServletRequest request,
                           @ApiParam(required = true, name = "pageNo", value = "第几页")
                           @RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo,
                           @ApiParam(required = true, name = "pageSize", value = "每页显示条数")
                           @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) throws Exception {

        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该用户没有查看收藏列表权限");
        }
        PageHelper.startPage(pageNo,pageSize);
        return ResultBean.success(userService.page((Integer) request.getAttribute("userId")));
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除用户", httpMethod = "DELETE" , notes="删除用户")
    public ResultBean delete(HttpServletRequest request, @PathVariable Integer id) throws Exception {

        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该用户没有删除收藏权限");
        }
        userService.delete(id);
        return ResultBean.SUCCESS;
    }
}
