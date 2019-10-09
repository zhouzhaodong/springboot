package com.zhouxiaoxi.consumer.controller;

import entity.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.GetUserService;

import java.util.List;

/**
 * @author zhouxiaoxi
 */
@RestController
public class GetUserController {

    @Reference
    GetUserService getUserService;

    @RequestMapping("getUserList")
    public List<User> getUserList(@RequestParam("name") String name){
        return getUserService.getUserList(name);
    }

}
