package com.xzt.mapper.user;

import com.xzt.entity.BookAndBooking;
import com.xzt.entity.LendAndBook;
import com.xzt.entity.TBookNumber;
import com.xzt.entity.TBookingRecornd;
import com.xzt.util.RetResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 预约借书
 * @Author PengBo
 * @CreateTime 2019/4/15 22:41
 * @Version 1.0.0
 */
public interface BookingBookMapper {

    TBookNumber queryBooked(@Param("bookId") Long bookId) throws Exception;

    int bookingBook(TBookingRecornd tBookingRecornd)throws Exception;

    int addBookingNumber(@Param("bookesNum")long bookesNum,@Param("bookId")long bookId)throws Exception;

    int updateBookNumber(@Param("lendNum")long lendNum ,@Param("bookId")long bookId)throws Exception;

    List<BookAndBooking> queryBooking(TBookingRecornd tBookingRecornd)throws Exception;

    List<BookAndBooking> queryAllBooking(@Param("offset") Integer offset, @Param("pageSize")Integer pageSize,
                                         @Param("name")String name)throws Exception;
    Integer queryBookingCount()throws Exception;


}
