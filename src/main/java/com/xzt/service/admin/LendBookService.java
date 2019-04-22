package com.xzt.service.admin;

import com.xzt.entity.BookAndBooking;
import com.xzt.entity.LendAndBook;
import com.xzt.entity.TBookNumber;
import com.xzt.entity.TLendBook;
import com.xzt.mapper.admin.LendBookMapper;
import com.xzt.mapper.user.BookingBookMapper;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author PengBo
 * @CreateTime 2019/4/16 17:24
 * @Version 1.0.0
 */
@Service
public class LendBookService {
    @Resource
    private LendBookMapper lendBookMapper;

    @Resource
    private BookingBookMapper bookingBookMapper;

    /**
     * 借书
     *
     * @param tLendBook
     * @return
     * @throws Exception
     */
    @Transactional
    public RetResult lend(TLendBook tLendBook) throws Exception {
        TBookNumber bookNumber = bookingBookMapper.queryBooked(tLendBook.getBookId());
        long number = bookNumber.getNumber();
        long lendNumber = bookNumber.getBookesNum();
        long canBookNumber = number - lendNumber;
        if (canBookNumber > 1) {
            int flag = lendBookMapper.lendBook(tLendBook);
            if (flag == 1) {
                bookingBookMapper.updateBookNumber(lendNumber + 1, tLendBook.getBookId());
            }
            return RetResponse.makeOKRsp("1");
        }
        return RetResponse.makeErrRsp("0");
    }

    /**
     * 还书
     * @param tLendBook
     * @return
     * @throws Exception
     */
    @Transactional
    public RetResult returnBook(TLendBook tLendBook) throws Exception {
        TBookNumber bookNumber = bookingBookMapper.queryBooked(tLendBook.getBookId());
        long lendNumber = bookNumber.getBookesNum();

        int flag = lendBookMapper.returnBook(tLendBook);
        if (flag == 1) {
            bookingBookMapper.updateBookNumber(lendNumber - 1, tLendBook.getBookId());
            return RetResponse.makeOKRsp("1");
        }
        return RetResponse.makeErrRsp("0");

    }

    /**
     * 查询所有人的预约
     *
     * @return
     */
    public RetResult queryAllBooking(Integer offset, Integer pageSize, String name) throws Exception {
        List<BookAndBooking> list = bookingBookMapper.queryAllBooking(offset, pageSize, name);
        int count = bookingBookMapper.queryBookingCount();
        Map<String, Object> map = new HashMap<>();
        map.put("count",count);
        map.put("bookingList", list);
        if (list.size() == 0) {
            return RetResponse.makeOKRsp("0");
        }
        return RetResponse.makeOKRsp("1", map);
    }

    /**
     * 查询所有人的借书情况
     * @param offset
     * @param pageSize
     * @param name
     * @return
     * @throws Exception
     */
    public RetResult queryAllLend(Integer offset, Integer pageSize, String name) throws Exception {
        List<LendAndBook> list = lendBookMapper.queryAllLend(offset, pageSize, name);
        int count = lendBookMapper.queryLendCount();
        Map<String, Object> map = new HashMap<>();
        map.put("count",count);
        map.put("LendList", list);
        if (list.size() == 0) {
            return RetResponse.makeOKRsp("0");
        }
        return RetResponse.makeOKRsp("1", map);
    }
}
