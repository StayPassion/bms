package com.xzt.controller.user;

import com.xzt.entity.TUserLogin;
import com.xzt.service.user.UserService;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author PengBo
 * @CreateTime 2019/4/15 12:36
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/user/book")
public class UserController {
    @Resource
    private UserService userService;


    /**
     *  注册
     * @param tUserLogin
     * @return
     */
    @PostMapping("/userRegister")
    public RetResult userInsert(@RequestBody TUserLogin tUserLogin){
        try {
            RetResult retResult = userService.userInsert(tUserLogin);
            return retResult;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务器内部错误");
        }
    }

    /**
     * 查询用户名是否存在
     * @param tUserLogin
     * @return
     */
    @PostMapping("/userIdQuery")
    public RetResult userIdQuery(@RequestBody TUserLogin tUserLogin){
        try {
            RetResult retResult = userService.userIdQuery(tUserLogin);
            return retResult;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务器内部错误");
        }
    }


}
