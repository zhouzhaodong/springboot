package xyz.zhouzhaodong.springboothttps.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制器
 * @author www.zhouzhaodong.xyz
 * @date Created in 2020/9/17 14:30
 */
@RestController
public class HttpsController {

    @RequestMapping("/")
    public String https(){
        return "success";
    }

}
