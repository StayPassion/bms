package com.xzt.service.user;

import com.xzt.entity.TBookNumber;
import com.xzt.entity.TBookingRecornd;
import com.xzt.mapper.user.BookingBookMapper;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author PengBo
 * @CreateTime 2019/4/16 12:17
 * @Version 1.0.0
 */

@Service
public class BookingBookService {
    @Resource
    private BookingBookMapper bookingBookMapper;

    /**
     * 查询书的数量
     * @param bookId
     * @return
     */
    public RetResult queryBooked(Long bookId) throws Exception{
        TBookNumber bookNumber = bookingBookMapper.queryBooked(bookId);
        long number = bookNumber.getNumber();
        long lendNumber = bookNumber.getLendNum();
        long canBookNumber = number - lendNumber;
        Map<String,Object> map = new HashMap<>();
        map.put("number",bookNumber);
        map.put("canBookNumber",canBookNumber);
        if (bookNumber == null){
            return RetResponse.makeErrRsp("0");
        }
        return RetResponse.makeOKRsp("1", map);
    }
    /**
     * 预约图书
     * @param tBookingRecornd
     * @return
     */
    @Transactional
    public RetResult bookingBook(TBookingRecornd tBookingRecornd) throws Exception{
        TBookNumber bookNumber = bookingBookMapper.queryBooked(tBookingRecornd.getBookId());
        long number = bookNumber.getNumber();
        long lendNumber = bookNumber.getLendNum();
        long canBookNumber = number - lendNumber;
        if (canBookNumber > 0){
            int flag = bookingBookMapper.bookingBook(tBookingRecornd);
            if (flag == 1){
                Long bookingNumber = bookNumber.getBookesNum()+1;
                bookingBookMapper.addBookingNumber(bookingNumber,tBookingRecornd.getBookId());
            }
            return RetResponse.makeOKRsp("1");
        }else {
            return RetResponse.makeErrRsp("0");
        }

    }
}
