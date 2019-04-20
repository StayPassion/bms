package com.xzt.mapper.user;

import com.xzt.entity.TUserInfo;
import com.xzt.entity.TUserLogin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @Author PengBo
 * @CreateTime 2019/4/15 12:43
 * @Version 1.0.0
 */
public interface UserMapper {
    int inserUser(TUserLogin tUserLogin)throws Exception;
    int userIdQuery(TUserLogin tUserLogin)throws Exception;
    TUserLogin userLogin(TUserLogin tUserLogin)throws Exception;
    int insertUserinfo(TUserInfo tUserInfo);
    int updateUserinfo(TUserInfo tUserInfo);
    TUserInfo queryUserInfo(@Param("userId") String userId);
}
