package xyz.zhouzhaodong.cache.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import xyz.zhouzhaodong.cache.entity.User;
import xyz.zhouzhaodong.cache.repository.UserRepository;
import xyz.zhouzhaodong.cache.service.UserService;

import javax.annotation.Resource;

/**
 * 实现类
 * @author zhouzhaodong
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    @CachePut(value = "user", key = "#result.id")
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    @CacheEvict(value = "user", key = "#id")
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    @CachePut(value = "user", key = "#user.id")
    public User update(User user) {
        return userRepository.updateById(user.getId(), user.getName(), user.getAddress(), user.getAge());
    }

    @Override
    @Cacheable(value = "user", key = "#id")
    public Object findById(int id) {
        return userRepository.findById(id);
    }
}
