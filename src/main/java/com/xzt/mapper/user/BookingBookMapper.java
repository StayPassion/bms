package com.xzt.mapper.user;

import com.xzt.entity.BookAndBooking;
import com.xzt.entity.TBookNumber;
import com.xzt.entity.TBookingRecornd;
import com.xzt.util.RetResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 预约借书
 * @Author PengBo
 * @CreateTime 2019/4/15 22:41
 * @Version 1.0.0
 */
public interface BookingBookMapper {

    TBookNumber queryBooked(Long bookId) throws Exception;

    int bookingBook(TBookingRecornd tBookingRecornd)throws Exception;

    int addBookingNumber(long bookesNum,long bookId)throws Exception;

    int updateBookNumber(long lendNum ,long bookId)throws Exception;

    List<BookAndBooking> queryBooking(TBookingRecornd tBookingRecornd)throws Exception;
}
