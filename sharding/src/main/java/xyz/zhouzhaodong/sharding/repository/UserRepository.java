package xyz.zhouzhaodong.sharding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.zhouzhaodong.sharding.entity.User;

/**
 * 数据访问层
 *
 * @author zhouzhaodong
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
