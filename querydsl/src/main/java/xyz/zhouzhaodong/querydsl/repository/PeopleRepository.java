package xyz.zhouzhaodong.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zhouzhaodong.querydsl.entity.People;

/**
 * 实现jpaRepository
 * @author zhouzhaodong
 */
public interface PeopleRepository extends JpaRepository<People, Integer> {
}
