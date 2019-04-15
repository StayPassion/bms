package com.xzt.mapper.admin;

import com.xzt.entity.TBookInfo;

import java.util.Map;

public interface BookManageMapper {

    int checkExsistByName(String name);

    int updateBookNumberByBookId(long bookId, int i);

    int insertBook(TBookInfo bookInfo);

    TBookInfo selectBookBy(Map<String, Object> map);

    int selectBookNumByBookId(Map<String, Object> map);
}
