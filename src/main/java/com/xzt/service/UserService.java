package com.xzt.service;

import com.xzt.entity.TUserLogin;
import com.xzt.mapper.UserMapper;
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
     * @param tUserLogin
     * @return
     * @throws Exception
     */
    public RetResult userInsert(TUserLogin tUserLogin) throws Exception {
        int flag = userMapper.inserUser(tUserLogin);
        if (flag == 1){
            return RetResponse.makeOKRsp("注册成功");
        }else {
            return RetResponse.makeOKRsp("注册失败");
        }
    }
    /**
     * 查询用户名是否存在
     * @param tUserLogin
     * @return
     */
    public RetResult userIdQuery(TUserLogin tUserLogin) throws Exception {
        int flag = userMapper.userIdQuery(tUserLogin);
        if (flag != 0){
            return RetResponse.makeErrRsp("用户已经存在");
        }
        return RetResponse.makeOKRsp("用户名可用");
    }

    /**
     * 用户登录
     * @param tUserLogin
     * @return
     */
    public RetResult userLogin(TUserLogin tUserLogin) {
        
        return RetResponse.makeOKRsp("注册失败");
    }
}
