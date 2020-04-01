package xyz.zhouzhaodong.www.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.zhouzhaodong.www.jpa.entity.Study;

/**
 * @author 10166815
 */
public interface StudyDao extends JpaRepository<Study, Integer> {

}
