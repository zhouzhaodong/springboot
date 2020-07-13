package xyz.zhouzhaodong.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import xyz.zhouzhaodong.cache.entity.User;

/**
 * 数据库访问层
 *
 * @author zhouzhaodong
 */
@Transactional(rollbackFor = Exception.class)
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 根据id更新
     *
     * @param id
     * @param name
     * @param address
     * @param age
     */
    @Modifying
    @Query(value = "update user u set u.name = :name, u.address = :address, u.age = :age  where u.id = :id", nativeQuery = true)
    void updateById(@Param("id") Integer id,
                    @Param("name") String name,
                    @Param("address") String address,
                    @Param("age") int age);

}
