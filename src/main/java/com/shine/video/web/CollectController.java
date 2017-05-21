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
public class CollectController extends BaseController{


    /**
     * 收藏列表展示接口
     * @return
     */
    @RequestMapping(value = "/collect",method = RequestMethod.GET)
    @ApiOperation(value="收藏列表", httpMethod = "GET" , notes="收藏列表")
    public ResultBean list(HttpServletRequest request,
                           @ApiParam(required = true, name = "pageNo", value = "第几页")
                           @RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo,
                           @ApiParam(required = true, name = "pageSize", value = "每页显示条数")
                           @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) throws Exception {

        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")&&
                Constant.USER_TYPE_ORDINARY!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该用户没有查看收藏列表权限");
        }
        /*
         * 第一个参数是第几页；第二个参数是每页显示条数。
         */
        PageHelper.startPage(pageNo,pageSize);
        return ResultBean.success(collectService.page((Integer) request.getAttribute("userId")));
    }


    /**
     * 收藏接口
     * @return
     */
    @RequestMapping(value = "/collect/{id}",method = RequestMethod.POST)
    @ApiOperation(value="收藏视频", httpMethod = "POST" , notes="收藏视频")
    public ResultBean collect(HttpServletRequest request, @PathVariable Integer id) throws Exception {

        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")&&
                Constant.USER_TYPE_ORDINARY!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该用户没有收藏权限");
        }
        collectService.collect((Integer) request.getAttribute("userId"),id);
        return ResultBean.SUCCESS;
    }

    /**
     * 删除收藏
     */
    @RequestMapping(value = "/collect/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除收藏", httpMethod = "DELETE" , notes="删除收藏")
    public ResultBean delete(HttpServletRequest request, @PathVariable Integer id) throws Exception {

        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")&&
                Constant.USER_TYPE_ORDINARY!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该用户没有删除收藏权限");
        }
        collectService.delete((Integer) request.getAttribute("userId"),id);
        return ResultBean.SUCCESS;
    }
}
