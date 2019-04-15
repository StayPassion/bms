package com.xzt.service.user;

import com.xzt.entity.TUserInfo;
import com.xzt.entity.TUserLogin;
import com.xzt.mapper.user.UserMapper;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author PengBo
 * @CreateTime 2019/4/15 12:39
 * @Version 1.0.0
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 注册
     *
     * @param tUserLogin
     * @return
     * @throws Exception
     */
    public RetResult userInsert(TUserLogin tUserLogin) throws Exception {
        int flag = userMapper.inserUser(tUserLogin);
        if (flag == 0) {
            return RetResponse.makeOKRsp("0");
        }
        return RetResponse.makeOKRsp("1");
    }

    /**
     * 查询用户名是否存在
     *
     * @param tUserLogin
     * @return
     */
    public RetResult userIdQuery(TUserLogin tUserLogin) throws Exception {
        int flag = userMapper.userIdQuery(tUserLogin);
        if (flag != 0) {
            return RetResponse.makeErrRsp("0");
        }
        return RetResponse.makeOKRsp("1");
    }

    /**
     * 用户登录
     * @param tUserLogin
     * @return
     */
    public RetResult userLogin(TUserLogin tUserLogin) throws Exception {
        TUserLogin tUserLogin1 = userMapper.userLogin(tUserLogin);
        if (tUserLogin1 == null) {
            return RetResponse.makeOKRsp("0");
        }
        return RetResponse.makeOKRsp("1", tUserLogin1);
    }
    /**
     * 添加个人信息
     * @param tUserInfo
     * @return
     */
    public RetResult insertUserInfo(TUserInfo tUserInfo) throws Exception {
        int flag = userMapper.insertUserinfo(tUserInfo);
        if (flag != 1){
            return RetResponse.makeErrRsp("0");
        }
        return RetResponse.makeOKRsp("1");
    }

    /**
     * 修改个人信息
     * @param tUserInfo
     * @return
     */
    public RetResult updatetUserInfo(TUserInfo tUserInfo) throws Exception {
        int flag = userMapper.updateUserinfo(tUserInfo);
        if (flag != 1){
            return RetResponse.makeErrRsp("0");
        }
        return RetResponse.makeOKRsp("1");

    }
    /**
     * 查询个人信息
     * @param userId
     * @return
     */
    public RetResult queryUserInfo(String userId) throws Exception {
        TUserInfo tUserInfo = userMapper.queryUserInfo(userId);
        if (tUserInfo == null){
            return RetResponse.makeErrRsp("0");
        }
        return RetResponse.makeOKRsp("1",tUserInfo);
    }
}
