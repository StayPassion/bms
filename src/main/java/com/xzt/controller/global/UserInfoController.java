package com.xzt.controller.global;

import com.xzt.entity.TUserInfo;
import com.xzt.entity.TUserLogin;
import com.xzt.service.global.UserInfoService;
import com.xzt.service.user.UserService;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author PengBo
 * @CreateTime 2019/4/15 21:12
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/q/user/book")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;
    /**
     * 用户登录
     * @param tUserLogin
     * @return
     */
    @PostMapping("/userLogin")
    public RetResult userLogin(@RequestBody TUserLogin tUserLogin, HttpSession httpSession){

        try {
            RetResult retResult = userInfoService.userLogin(tUserLogin,httpSession);
            return retResult;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务器内部错误");
        }
    }

    /**
     * 注销
     * @param httpSession
     * @param sessionStatus
     * @return
     */
    @PostMapping("/logout")
    public RetResult logout(HttpSession httpSession, SessionStatus sessionStatus) {
        try {
            userInfoService.logout(httpSession,sessionStatus);
            return RetResponse.makeOKRsp("1");
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务内部错误");
        }
    }

    /**
     * 添加个人信息
     * @param tUserInfo
     * @return
     */
    @PostMapping("/insertUserInfo")
    public RetResult insertUserInfo(@RequestBody TUserInfo tUserInfo){
        try {
            RetResult retResult = userInfoService.insertUserInfo(tUserInfo);
            return retResult;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务器内部错误");
        }
    }
    /**
     * 修改个人信息
     * @param tUserInfo
     * @return
     */
    @PostMapping("/updateUserInfo")
    public RetResult updateUserInfo(@RequestBody TUserInfo tUserInfo){
        try {
            RetResult retResult = userInfoService.updatetUserInfo(tUserInfo);
            return retResult;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务器内部错误");
        }
    }
    /**
     * 查询个人信息
     * @param tUserInfo
     * @return
     */
    @PostMapping("/queryUserInfo")
    public RetResult queryUserInfo(@RequestBody TUserInfo tUserInfo){
        try {
            RetResult retResult = userInfoService.queryUserInfo(tUserInfo.getUserId());
            return retResult;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务器内部错误");
        }
    }
}
