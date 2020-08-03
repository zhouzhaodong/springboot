package xyz.zhouzhaodong.sharding.service;

import xyz.zhouzhaodong.sharding.entity.User;

import java.util.List;

/**
 * 服务层
 *
 * @author zhouzhaodong
 */
public interface UserService {

    /**
     * 新增
     *
     * @param user
     * @return
     */
    User addUser(User user);

    /**
     * 查询所有
     *
     * @return
     */
    List<User> list();

}
