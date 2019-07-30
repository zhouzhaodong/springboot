package com.zhouxiaoxi.filter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouzhaodong
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping(value = "/hello")
    public void test(){
        log.info("Hello World!");
    }

}
