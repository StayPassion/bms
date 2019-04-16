package com.xzt.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.xzt.entity.TBookNumber;
import com.xzt.entity.TBookingRecornd;
import com.xzt.service.user.BookingBookService;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Date;

/**
 * 预约借书类
 * @Author PengBo
 * @CreateTime 2019/4/15 22:34
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/user/booking")
public class BookingBookController {
    @Resource
    private BookingBookService bookingBookService;

    /**
     * 查询书的数量
     * @param tBookNumber
     * @return
     */
    @PostMapping("/queryBooked")
    public RetResult queryBooked(@RequestBody TBookNumber tBookNumber) {
        try {
            RetResult result = bookingBookService.queryBooked(tBookNumber.getBookId());
            return result;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("内部服务器错误");
        }
    }

    /**
     * 预约图书
     * @param jsonObject
     * @return
     */
    @PostMapping("/bookingBook")
    public RetResult bookingBook(@RequestBody JSONObject jsonObject) {
        String userId = jsonObject.getString("userId");
        Integer bookId = jsonObject.getInteger("bookId");
        String bookingTime = jsonObject.getString("bookingTime");
        String bookingDeadline = jsonObject.getString("bookingDeadline");
        TBookingRecornd tBookingRecornd = new TBookingRecornd();
        tBookingRecornd.setUserId(userId);
        tBookingRecornd.setBookId(bookId);
        java.sql.Date date1 = Date.valueOf(bookingTime);
        java.sql.Date date2 = Date.valueOf(bookingDeadline);
        tBookingRecornd.setBookingTime(date1);
        tBookingRecornd.setBookingDeadline(date2);

        try {
            RetResult result = bookingBookService.bookingBook(tBookingRecornd);
            return result;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("内部服务器错误");
        }
    }

}
