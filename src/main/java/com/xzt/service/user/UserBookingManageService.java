package com.xzt.service.user;

import com.alibaba.fastjson.JSONObject;
import com.xzt.entity.TBookInfo;
import com.xzt.entity.TClassInfo;
import com.xzt.mapper.user.UserBookingManageMapper;
import com.xzt.util.ChineseToPinyin;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserBookingManageService {

    @Resource
    private UserBookingManageMapper userBookingManageMapper;

    public RetResult searchSorts() {
        List<TClassInfo> list = userBookingManageMapper.getBookSorts();
        return RetResponse.makeOKRsp("1",list);

    }

    //分类查询
    public RetResult searchBookBySort(Map<String,Object> map) {
        List<TBookInfo> list = userBookingManageMapper.getBooksBy(map);
        if (list != null && list.size() > 0){
            return RetResponse.makeOKRsp("1",list);
        }else {
            return RetResponse.makeErrRsp("0");
        }

    }

    //首字母查询
    public RetResult searchBookByFirstChar(char firstChar, int offset, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        List<TBookInfo> bookInfoList = userBookingManageMapper.getBooksBy(map);
        List<TBookInfo> tempList = null;
        List<TBookInfo> resultList = null;
        for (int i = 0; i < bookInfoList.size(); i++){
            if (firstChar == ChineseToPinyin.getPinYinHeadChar(bookInfoList.get(i).getName())){
                tempList.add(bookInfoList.get(i));
            }
        }
        //对数据结果进行分页



        return null;
    }


    //查询bookids
    public List searchBookIds(List classIdList) {
        List list = userBookingManageMapper.searchBookIdsByClassId(classIdList);
        return list;
    }
}
