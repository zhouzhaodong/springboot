package xyz.zhouzhaodong.www.jpa.service;

import org.springframework.stereotype.Service;
import xyz.zhouzhaodong.www.jpa.entity.Study;

import java.util.List;
import java.util.Optional;

/**
 * @author 10166815
 */
@Service
public interface StudyService {

    /**
     * 新增
     * @param study
     * @return
     */
    String addStudy(Study study);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    void deleteStudy(int id);

    /**
     * 更新
     * @param study
     * @return
     */
    Study updateStudy(Study study);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Optional<Study> getStudyById(int id);

    /**
     * 查询所有
     * @return
     */
    List<Study> getStudyList();

}
