package xyz.zhouzhaodong.sharding.service.impl;

import org.springframework.stereotype.Service;
import xyz.zhouzhaodong.sharding.entity.User;
import xyz.zhouzhaodong.sharding.repository.UserRepository;
import xyz.zhouzhaodong.sharding.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务层实现类
 *
 * @author zhouzhaodong
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public User addUser(User user) {

        // 强制路由主库
//        HintManager.getInstance().setMasterRouteOnly();
        return userRepository.save(user);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }
}
