package xyz.zhouzhaodong.crossdomaintwo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 跨域8080端口方法
 * @author zhouzhaodong
 */
@RestController
public class CrossDomainTwoController {

    /**
     * 测试端口
     * @return
     */
//    @CrossOrigin
    @RequestMapping("/hello")
    public String hello(){
        return "这是一个来自8081端口的接口！";
    }

}
