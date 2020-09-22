package xyz.zhouzhaodong.springbooth2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zhouzhaodong.springbooth2.entity.User;

/**
 * dao
 * @author zhouzhaodong
 */
public interface UserDao extends JpaRepository<User, Integer> {
}
