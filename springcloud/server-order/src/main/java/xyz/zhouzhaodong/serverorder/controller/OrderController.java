package xyz.zhouzhaodong.serverorder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者方法
 * @author zhouzhaodong
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 测试方法
     * @return
     */
    @RequestMapping("/getMessage")
    public String getMessage(){
        return "order-one";
    }

}
