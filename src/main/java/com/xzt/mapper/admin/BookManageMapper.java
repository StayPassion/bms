package com.xzt.mapper.admin;

import com.xzt.entity.TBookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookManageMapper {

    int checkExsistByName(String bookName);

    int updateBookNumberByBookId(long bookId, int i);

    int insertBook(TBookInfo bookInfo);

    TBookInfo selectBookBy(Map<String, Object> map);

    int selectBookNumByBookId(Map<String, Object> map);

    int getMostId();

    int insertBookNumber(long bookId, int number);

    void insertBK(List list);

    void updateBookInfoById(TBookInfo bookInfo);

    //删除书籍相关信息

    void deleteBookInfo(Long bookId);

    void deleteBookClass(Long bookId);

    void deleteBookNumber(Long bookId);

    void deletebookRecord(Long bookId);

    void deleteLendBook(Long bookId);
}
