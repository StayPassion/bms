package com.xzt.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.xzt.service.user.UserBookingManageService;
import com.xzt.util.RetResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 本Controller接管了用户对于书籍的所有请求
 */

@RestController
@RequestMapping(("/user/book"))
public class UserBookingManageController {
    @Resource
    private UserBookingManageService userBookingManageService;

    //分类查询
    @RequestMapping("/searchBySort")
    public RetResult searchBookBySort(@RequestBody JSONObject jsonObject){
        RetResult retResult = userBookingManageService.searchBookBySort(jsonObject);
        return retResult;
    }

    //返回类别接口
    @RequestMapping("/getSorts")
    public RetResult getSorts(){
        return userBookingManageService.searchSorts();
    }

}
