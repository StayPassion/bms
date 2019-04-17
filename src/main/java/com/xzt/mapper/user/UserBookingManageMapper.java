package com.xzt.mapper.user;

import com.xzt.entity.TBookInfo;
import com.xzt.entity.TBookNumber;
import com.xzt.entity.TClassInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserBookingManageMapper {

    //获取图书分类
    List<TClassInfo> getBookSorts();

    List<TBookInfo> getBooksBy(Map<String,Object> map);

    List searchBookIdsByClassId(List classIdList);

    TBookNumber findBookNumById(@Param("bookId") long bookId);

    int searchBookNumByName(@Param("name") String name);

    int searchBookNumBy(Map<String, Object> selectMap);
}
