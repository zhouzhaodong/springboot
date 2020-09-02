package xyz.zhouzhaodong.querydsl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zhouzhaodong.querydsl.entity.People;
import xyz.zhouzhaodong.querydsl.service.PeopleService;

import javax.annotation.Resource;

/**
 * controller
 * @author zhouzhaodong
 */
@RestController
public class PeopleController {

    @Resource
    PeopleService peopleService;

    @RequestMapping("/selectById")
    public People selectById(){
        return peopleService.selectOne(0);
    }

}
