package com.xzt.service.global;

import com.xzt.entity.LendAndBook;
import com.xzt.entity.TLendBook;
import com.xzt.mapper.admin.LendBookMapper;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查询借书情况
 *
 * @Author PengBo
 * @CreateTime 2019/4/20 22:37
 * @Version 1.0.0
 */
@Service
public class QueryLendBook {
    @Resource
    private LendBookMapper lendBookMapper;

    /**
     * 查询一个人所有的借书情况
     *
     * @param tLendBook
     * @return
     * @throws Exception
     */
    public RetResult queryLendBook(TLendBook tLendBook) throws Exception {
        List<LendAndBook> list = lendBookMapper.queryLendBook(tLendBook);
        if (list.size() == 0) {
            return RetResponse.makeErrRsp("0");
        }
        return RetResponse.makeOKRsp("1", list);
    }
}
