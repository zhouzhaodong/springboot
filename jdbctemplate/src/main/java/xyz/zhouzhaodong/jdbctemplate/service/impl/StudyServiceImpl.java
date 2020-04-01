package xyz.zhouzhaodong.jdbctemplate.service.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import xyz.zhouzhaodong.jdbctemplate.entity.Study;
import xyz.zhouzhaodong.jdbctemplate.service.StudyService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 10166815
 */
@Service
public class StudyServiceImpl implements StudyService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addStudy(Study study) {
        return jdbcTemplate.update("insert into study(name, age, address) values (?, ?, ?)",
                study.getName(), study.getAge(), study.getAddress());
    }

    @Override
    public int deleteStudy(int id) {
        return jdbcTemplate.update("delete from study where id = ?", id);
    }

    @Override
    public int updateStudy(Study study) {
        return jdbcTemplate.update("update study set name = ?, age = ?, address = ? where id = ?",
                study.getName(), study.getAge(), study.getAddress(), study.getId());
    }

    @Override
    public Study getStudyById(int id) {
        List<Study> list = jdbcTemplate.query("select * from study where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Study.class));
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Study> getStudyList() {
        return jdbcTemplate.query("select * from study", new Object[]{}, new BeanPropertyRowMapper(Study.class));
    }
}
