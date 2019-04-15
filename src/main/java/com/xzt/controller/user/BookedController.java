package com.xzt.controller.user;

import com.xzt.mapper.user.BookedService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 预约借书类
 * @Author PengBo
 * @CreateTime 2019/4/15 22:34
 * @Version 1.0.0
 */
@RestController
public class BookedController {
    @Resource
    private BookedService bookedService;

}
