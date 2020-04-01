package xyz.zhouzhaodong.www.jpa.service.impl;

import org.springframework.stereotype.Service;
import xyz.zhouzhaodong.www.jpa.dao.StudyDao;
import xyz.zhouzhaodong.www.jpa.entity.Study;
import xyz.zhouzhaodong.www.jpa.service.StudyService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author 10166815
 */
@Service
public class StudyServiceImpl implements StudyService {

    @Resource
    StudyDao studyDao;

    /**
     * 新增
     * @param study
     * @return
     */
    @Override
    public String addStudy(Study study) {
        return studyDao.save(study).toString();
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public void deleteStudy(int id) {
        studyDao.deleteById(id);
    }

    /**
     * 更新
     * @param study
     * @return
     */
    @Override
    public Study updateStudy(Study study) {
         return studyDao.saveAndFlush(study);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Optional<Study> getStudyById(int id) {
        return studyDao.findById(id);
    }

    @Override
    public List<Study> getStudyList() {
        return studyDao.findAll();
    }
}
