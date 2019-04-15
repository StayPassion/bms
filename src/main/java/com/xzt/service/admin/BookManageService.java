package com.xzt.service.admin;

import com.xzt.entity.TBookInfo;
import com.xzt.mapper.admin.BookManageMapper;
import com.xzt.util.RetCode;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Service("bmservice")
public class BookManageService {
    @Resource
    private BookManageMapper bookManageMapper;

    @Transactional
    public RetResult addBook(TBookInfo bookInfo, int number) {
        Map<String,Object> map = new HashMap<>();
        //判断书本是否存在
        if(bookManageMapper.checkExsistByName(bookInfo.getName()) == 1){
           //书名存在
            //获取书籍数量
            map.put("bookId",bookInfo.getBookId());
            int oldBookNum = bookManageMapper.selectBookNumByBookId(map);
            //更新书籍数量
            int i = bookManageMapper.updateBookNumberByBookId(bookInfo.getBookId(),number+oldBookNum);
            if (i == 1){
                return RetResponse.makeOKRsp("1");
            }else{
                return RetResponse.makeErrRsp("0");
            }
        }else{
            //插入书本信息
            int resp1 = bookManageMapper.insertBook(bookInfo);
            int resp2 = bookManageMapper.updateBookNumberByBookId(bookInfo.getBookId(),number);
            if (resp1 == 1 && resp2 == 1){
                return RetResponse.makeOKRsp("1");
            }else{
                return RetResponse.makeErrRsp("0");
            }
        }


    }

    //检测书籍是否存在
    public RetResult checkBookExsist(String bookName) {
        Map<String,Object> map = new HashMap<>();
        map.put("bookName",bookName);
        if(bookManageMapper.checkExsistByName(bookName) == 1){
            //书籍已存在
            TBookInfo bookInfo = bookManageMapper.selectBookBy(map);
            Map<String,Object> resultMap = new HashMap<>();
            resultMap.put("bookInfo",bookInfo);
            return RetResponse.makeOKRsp("0",bookInfo);
        }else{
            return RetResponse.makeOKRsp("1");
        }
    }
}
