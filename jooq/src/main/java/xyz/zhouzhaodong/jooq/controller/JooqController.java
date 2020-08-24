package xyz.zhouzhaodong.jooq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zhouzhaodong.jooq.entity.JooqPojo;
import xyz.zhouzhaodong.jooq.service.JooqService;

import javax.annotation.Resource;

/**
 * 控制层
 *
 * @author zhouzhaodong
 */
@RestController
public class JooqController {

    @Resource
    JooqService jooqService;

    @RequestMapping("/selectByName")
    public JooqPojo selectByName(String name) {
        return jooqService.selectByName(name);
    }

}
