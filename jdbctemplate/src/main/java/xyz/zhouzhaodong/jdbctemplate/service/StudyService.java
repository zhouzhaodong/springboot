package xyz.zhouzhaodong.jdbctemplate.service;

import org.springframework.stereotype.Service;
import xyz.zhouzhaodong.jdbctemplate.entity.Study;

import java.util.List;

/**
 * @author 10166815
 */
public interface StudyService {

    /**
     * 新增
     * @param study
     * @return
     */
    int addStudy(Study study);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteStudy(int id);

    /**
     * 更新
     * @param study
     * @return
     */
    int updateStudy(Study study);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    Study getStudyById(int id);

    /**
     * 获取list
     * @return
     */
    List<Study> getStudyList();

}
