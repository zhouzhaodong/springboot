package xyz.zhouzhaodong.cache.service;

import org.springframework.stereotype.Service;
import xyz.zhouzhaodong.cache.entity.User;

/**
 * Service
 * @author zhouzhaodong
 */
@Service
public interface UserService {

    /**
     * 新增
     * @param user
     * @return
     */
    User insert(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    void delete(int id);

    /**
     * 更新
     * @param user
     * @return
     */
    void update(User user);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Object findById(int id);

}
