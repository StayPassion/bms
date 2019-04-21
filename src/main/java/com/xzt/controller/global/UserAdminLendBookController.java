package com.xzt.controller.global;


import com.xzt.entity.TLendBook;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xzt.service.global.QueryLendBook;
import javax.annotation.Resource;


/**
 * @Author PengBo
 * @CreateTime 2019/4/20 22:39
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/q/user/lendbook")
public class UserAdminLendBookController {
    @Resource
    private QueryLendBook queryLendBook ;
    /**
     * 查询一个人所有的借书情况
     * @param tLendBook
     * @return
     */
    @PostMapping("/queryLendBook")
    public RetResult queryLendBook(@RequestBody TLendBook tLendBook){
        try {
            RetResult retResult = queryLendBook.queryLendBook(tLendBook);
            return retResult;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务器内部错误");
        }
    }

}
