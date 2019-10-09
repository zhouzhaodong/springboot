package com.zhouxiaoxi.provider.service.impl;

import entity.User;
import org.apache.dubbo.config.annotation.Service;
import service.GetUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者实现类
 * @author zhouxiaoxi
 */
@Service
public class GetUserServiceImpl implements GetUserService {

    @Override
    public List<User> getUserList(String name) {
        //此处没有连接数据库，所以就先生成几条数据返回即可。
        System.out.println(name);
        List<User> list = new ArrayList<>();
        list.add(new User("小明",20));
        list.add(new User("小强",21));
        list.add(new User("小红",22));
        return list;
    }
}
