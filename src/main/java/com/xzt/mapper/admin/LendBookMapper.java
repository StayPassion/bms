package com.xzt.mapper.admin;

import com.xzt.entity.TLendBook;

/**
 * @Author PengBo
 * @CreateTime 2019/4/16 17:25
 * @Version 1.0.0
 */
public interface LendBookMapper {
    int lendBook(TLendBook tLendBook)throws Exception;

    int returnBook(TLendBook tLendBook)throws Exception;
}