package xyz.zhouzhaodong.mybatis.service;

import org.springframework.stereotype.Service;
import xyz.zhouzhaodong.mybatis.entity.Study;
import xyz.zhouzhaodong.mybatis.mapper.StudyMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 10166815
 */
@Service
public class StudyService {

    @Resource
    StudyMapper studyMapper;

    /**
     * 新增
     * @param study
     * @return
     */
    public int add(Study study){
        return studyMapper.add(study.getName(), study.getAge(), study.getAddress());
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(int id){
        return studyMapper.delete(id);
    }

    /**
     * 修改
     * @param study
     * @return
     */
    public int update(Study study){
        return studyMapper.update(study.getId(), study.getName(), study.getAge(), study.getAddress());
    }

    /**
     * 查询一条数据
     * @param id
     * @return
     */
    public Study findOne(int id){
        return studyMapper.findOne(id);
    }

    /**
     * 查询所有
     * @return
     */
    public List<Study> findList(){
        return studyMapper.findAll();
    }

}
