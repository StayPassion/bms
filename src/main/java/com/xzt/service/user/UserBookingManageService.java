package com.xzt.service.user;

import com.alibaba.fastjson.JSONObject;
import com.xzt.entity.TClassInfo;
import com.xzt.mapper.user.UserBookingManageMapper;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserBookingManageService {

    @Resource
    private UserBookingManageMapper userBookingManageMapper;

    public RetResult searchSorts() {
        List<TClassInfo> list = userBookingManageMapper.getBookSorts();
        return RetResponse.makeOKRsp("1",list);

    }

/*    public RetResult searchBookBySort(JSONObject jsonObject) {
        int offset = jsonObject.getInteger("offset");
        int pageSize = jsonObject.getInteger("pageSize");
        String claasIds = jsonObject.getString("classIds");
        char letter = jsonObject.getString("letter").charAt(0);

    }*/
}
