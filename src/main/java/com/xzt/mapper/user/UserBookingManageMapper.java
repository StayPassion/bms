package com.xzt.mapper.user;

import com.xzt.entity.TClassInfo;

import java.util.List;

public interface UserBookingManageMapper {

    //获取图书分类
    List<TClassInfo> getBookSorts();

}
