package com.xzt.service.global;

import com.xzt.entity.TUserInfo;
import com.xzt.entity.TUserLogin;
import com.xzt.mapper.user.UserMapper;
import com.xzt.util.RetResponse;
import com.xzt.util.RetResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author PengBo
 * @CreateTime 2019/4/15 21:14
 * @Version 1.0.0
 */

@Service
public class UserInfoService {
    @Resource
    private UserMapper userMapper;
    /**
     * 用户登录
     * @param tUserLogin
     * @return
     */
    public RetResult userLogin(TUserLogin tUserLogin,HttpSession session) throws Exception {

        TUserLogin tUserLogin1 = userMapper.userLogin(tUserLogin);

        if (tUserLogin1 == null) {
            return RetResponse.makeOKRsp("0");
        }
        session.setAttribute("userId",tUserLogin1.getUserId());
        return RetResponse.makeOKRsp("1", tUserLogin1);
    }
    /**
     * 注销
     * @param httpSession
     * @param sessionStatus
     * @throws Exception
     */
    public void logout(HttpSession httpSession, SessionStatus sessionStatus) throws Exception {
        //清除SessionAttributes数据
        sessionStatus.setComplete();
        //让session(HttpSession)失效，清除session中所有数据
        httpSession.invalidate();
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
