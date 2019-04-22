package com.xzt.controller.admin;

import com.alibaba.fastjson.JSONObject;
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
            RetResult retResult = lendBookService.lend(tLendBook);
            return retResult;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务器内部错误");
        }
    }


    /**
     * 还书
     * @param tLendBook
     * @return
     */
    @PostMapping("/returnBook")
    public RetResult returnBook(@RequestBody TLendBook tLendBook){
        try {
            RetResult retResult = lendBookService.returnBook(tLendBook);
            return retResult;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务器内部错误");
        }
    }

    /**
     * 查询所有的预约
     * @return
     */
    @PostMapping("/queryAllBooking")
    public RetResult queryAllBooking(@RequestBody JSONObject jsonObject){

        Integer offset = jsonObject.getInteger("offset");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String name = jsonObject.getString("name");
        try {
            RetResult retResult = lendBookService.queryAllBooking(offset,pageSize,name);
            return retResult;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务器内部错误");
        }
    }



}
