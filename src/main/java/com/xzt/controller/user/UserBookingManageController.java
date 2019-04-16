package com.xzt.controller.user;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xzt.service.user.UserBookingManageService;
import com.xzt.util.RetResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 本Controller接管了用户对于书籍的所有请求
 */

@RestController
@RequestMapping(("/q/user/book"))
public class UserBookingManageController {
    @Resource
    private UserBookingManageService userBookingManageService;

    //分类查询
    @RequestMapping("/searchBySort")
    public RetResult searchBookBySort(@RequestBody JSONObject jsonObject){
        Map<String,Object> map = new HashMap<>();
        Character letter = null;
        Integer offset = null;
        Integer pageSize = null;
        String bookName = null;
        JSONArray claasIds = null;
        if (jsonObject.getString("letter") != null){
            letter = jsonObject.getString("letter").charAt(0);
        }
        if (jsonObject.getString("bookName") != null){
            bookName = jsonObject.getString("bookName");
            map.put("name",bookName);

        }
        if (jsonObject.getInteger("offset") != null){
            offset = jsonObject.getInteger("offset");
            map.put("offset",offset);
        }
        if (jsonObject.getInteger("pageSize") != null){
            pageSize = jsonObject.getInteger("pageSize");
            map.put("pageSize",pageSize);
        }
        if (jsonObject.getJSONArray("classIds") != null){
            claasIds = jsonObject.getJSONArray("classIds");
        }

        if (letter != null){
            //首字母查询
            return userBookingManageService.searchBookByFirstChar(letter.charValue());
        }else{
            //类别查询和模糊查询
            //类别不为空，查询bookids
            if (claasIds != null){
                List classIdList = new ArrayList();
                for (int i = 0; i < claasIds.size(); i++){
                    classIdList.add(claasIds.get(i));
                }
                List bookIdList = userBookingManageService.searchBookIds(classIdList);
                if (bookIdList != null){
                    //类别下的模糊查询
                    map.put("bookIds",bookIdList);
                }
            }
            RetResult retResult = userBookingManageService.searchBookBySort(map);
            return retResult;
        }
    }

    //返回类别接口
    @RequestMapping("/getSorts")
    public RetResult getSorts(){
        return userBookingManageService.searchSorts();
    }


}
