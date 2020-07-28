package xyz.zhouzhaodong.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试控制器
 * @author zhouzhaodong
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String view(){
        return "index";
    }

}
