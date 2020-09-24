package xyz.zhouzhaodong.springbootdruid.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zhouzhaodong.springbootdruid.entity.Person;

/**
 * @author zhouzhaodong
 */
public interface PersonRepository extends JpaRepository<Person,Integer> {
}
