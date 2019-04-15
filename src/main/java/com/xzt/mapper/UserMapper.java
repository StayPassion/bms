package com.xzt.mapper;

import com.xzt.entity.TUserLogin;
import org.apache.ibatis.annotations.Insert;

/**
 * @Author PengBo
 * @CreateTime 2019/4/15 12:43
 * @Version 1.0.0
 */
public interface UserMapper {
    int inserUser(TUserLogin tUserLogin)throws Exception;
    int userIdQuery(TUserLogin tUserLogin)throws Exception;
}
