package xyz.zhouzhaodong.jdbctemplate.controller;

import org.springframework.web.bind.annotation.*;
import xyz.zhouzhaodong.jdbctemplate.entity.Study;
import xyz.zhouzhaodong.jdbctemplate.service.StudyService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 10166815
 */
@RestController
public class StudyController {

    @Resource
    StudyService studyService;

    @PutMapping("/study")
    public int addStudy(@RequestBody Study study) {
        return studyService.addStudy(study);
    }

    @DeleteMapping("/study")
    public int deleteStudy(@RequestParam int id){
        return studyService.deleteStudy(id);
    }

    @PostMapping("/study")
    public int updateStudy(@RequestBody Study study){
        return studyService.updateStudy(study);
    }

    @GetMapping("/study/{id}")
    public Study getStudyById(@PathVariable("id") int id){
        return studyService.getStudyById(id);
    }

    @GetMapping("/study")
    public List<Study> getStudyList(){
        return studyService.getStudyList();
    }

}
