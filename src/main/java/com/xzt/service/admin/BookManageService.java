package com.xzt.service.admin;

import com.xzt.entity.TBookClass;
import com.xzt.entity.TBookInfo;
import com.xzt.mapper.admin.BookManageMapper;
import com.xzt.util.RetCode;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("bmservice")
public class BookManageService {
    @Resource
    private BookManageMapper bookManageMapper;

    @Transactional
    public RetResult addBook(TBookInfo bookInfo, int number, List classList) {
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
            try {
                int bookId = bookManageMapper.getMostId();
                bookId += 1;
                bookInfo.setBookId(bookId);
                bookManageMapper.insertBook(bookInfo);
                bookManageMapper.insertBookNumber(bookInfo.getBookId(),number);
                //插入书籍类别表
                List<TBookClass> bcList = new ArrayList<>();
                for (int i = 0; i < classList.size(); i++){
                    TBookClass tBookClass = new TBookClass();
                    tBookClass.setBookId(bookInfo.getBookId());
                    tBookClass.setClassId((Long) classList.get(i));
                    bcList.add(tBookClass);
                }
                bookManageMapper.insertBK(bcList);
                return RetResponse.makeOKRsp("1");
            }catch (Exception e){
                e.printStackTrace();
                return RetResponse.makeErrRsp("0");
            }
        }


    }

    //检测书籍是否存在
    public RetResult checkBookExsist(String bookName) {

        if(bookManageMapper.checkExsistByName(bookName) == 1){
            //书籍已存在
            Map<String,Object> map = new HashMap<>();
            map.put("name",bookName);
            TBookInfo bookInfo = bookManageMapper.selectBookBy(map);
            return RetResponse.makeOKRsp("0",bookInfo);
        }else{
            return RetResponse.makeOKRsp("1");
        }
    }
}
