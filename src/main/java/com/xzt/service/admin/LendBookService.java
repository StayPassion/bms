package com.xzt.service.admin;

import com.xzt.entity.TBookNumber;
import com.xzt.entity.TLendBook;
import com.xzt.mapper.admin.LendBookMapper;
import com.xzt.mapper.user.BookingBookMapper;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
                int flag2 = bookingBookMapper.updateBookNumber(lendNumber + 1, tLendBook.getBookId());
            }
            return RetResponse.makeOKRsp("1");
        }
        return RetResponse.makeErrRsp("0");
    }

    /**
     * 还书
     *
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
     * 查询一个人所有的借书情况
     * @param tLendBook
     * @return
     * @throws Exception
     */
    public RetResult queryLendBook(TLendBook tLendBook) throws Exception {
        List<TBookNumber> list = lendBookMapper.queryLendBook(tLendBook);
        if (list.size() == 0){
            return RetResponse.makeErrRsp("0");
        }
            return RetResponse.makeOKRsp("1", list);
    }
}
