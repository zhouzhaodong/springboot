package service;

import entity.User;

import java.util.List;

/**
 * 接口类
 * @author zhouxiaoxi
 */
public interface GetUserService {

    /**
     * 根据名称获取用户信息
     * @param name 名称
     * @return
     */
    List<User> getUserList(String name);

}
