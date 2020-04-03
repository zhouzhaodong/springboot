package xyz.zhouzhaodong.www.jpa.controller;

import org.springframework.web.bind.annotation.*;
import xyz.zhouzhaodong.www.jpa.entity.Study;
import xyz.zhouzhaodong.www.jpa.service.StudyService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author 10166815
 */
@RestController
public class StudyController {

    @Resource
    StudyService studyService;

    /**
     * 新增
     * @param study
     * @return
     */
    @PutMapping("/study")
    public String addStudy(@RequestBody Study study){
        return studyService.addStudy(study);
    }

    /**
     * 根据id删除
     * @param id
     */
    @DeleteMapping("/study")
    public void deleteStudy(@RequestParam("id") int id){
        studyService.deleteStudy(id);
    }

    /**
     * 更新
     * @param study
     * @return
     */
    @PostMapping("/study")
    public Study updateStudy(@RequestBody Study study){
        return studyService.updateStudy(study);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/study/{id}")
    public Optional<Study> getStudyById(@PathVariable("id") int id){
        return studyService.getStudyById(id);
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/study")
    public List<Study> getStudyList(){
        return studyService.getStudyList();
    }

}
