package xyz.zhouzhaodong.mybatis.controller;

import org.springframework.web.bind.annotation.*;
import xyz.zhouzhaodong.mybatis.entity.Study;
import xyz.zhouzhaodong.mybatis.service.StudyService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 10166815
 */
@RestController
public class MybatisController {

    @Resource
    StudyService studyService;

    /**
     * 新增
     * @param study
     * @return
     */
    @PostMapping("/study")
    public int add(@RequestBody Study study){
        return studyService.add(study);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/study/{id}")
    public int delete(@PathVariable("id") int id){
        return studyService.delete(id);
    }

    /**
     * 修改
     * @param study
     * @return
     */
    @PutMapping("/study")
    public int update(@RequestBody Study study){
        return studyService.update(study);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/study/{id}")
    public Study findOne(@PathVariable("id") int id){
        return studyService.findOne(id);
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/study")
    public List<Study> findAll(){
        return studyService.findList();
    }

}
