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

import javax.annotation.Resource;

/**
 * @Author PengBo
 * @CreateTime 2019/4/15 21:12
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/user/book")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;
    /**
     * 用户登录
     * @param tUserLogin
     * @return
     */
    @PostMapping("/userLogin")
    public RetResult userLogin(@RequestBody TUserLogin tUserLogin){
        try {
            RetResult retResult = userInfoService.userLogin(tUserLogin);
            return retResult;
        } catch (Exception e) {
            return RetResponse.makeInternalServiceErrors("服务器内部错误");
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
