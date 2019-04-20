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
@RequestMapping("/q/user/booking")
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
     * @param tBookingRecornd
     * @return
     */
    @PostMapping("/bookingBook")
    public RetResult bookingBook(@RequestBody TBookingRecornd tBookingRecornd) {
        try {
            RetResult result = bookingBookService.bookingBook(tBookingRecornd);
            return result;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("内部服务器错误");
        }
    }
}
