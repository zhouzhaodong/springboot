package com.zhouzhaodong.pagehelper.controller;


import com.zhouzhaodong.pagehelper.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-06-03
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @RequestMapping(value = "/list")
    public Object findAll(){

        //第一页，两条数据
        return studentService.findList(1,2);

    }

}
