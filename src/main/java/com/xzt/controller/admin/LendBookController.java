package com.xzt.controller.admin;

import com.xzt.entity.TLendBook;
import com.xzt.service.admin.LendBookService;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author PengBo
 * @CreateTime 2019/4/16 17:23
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/q/admin/book")
public class LendBookController {
    @Resource
    private LendBookService lendBookService ;

    /**
     * 借书
     * @param tLendBook
     * @return
     */
    @PostMapping("/lendBook")
    public RetResult lendBook(@RequestBody TLendBook tLendBook){
        try {
            RetResult retResult = lendBookService.lendBook(tLendBook);
            return retResult;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务器内部错误");
        }
    }

    @PostMapping("")
    public RetResult returnBook(@RequestBody TLendBook tLendBook){
        try {
            RetResult retResult = lendBookService.returnBook(tLendBook);
            return retResult;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务器内部错误");
        }
    }

}
