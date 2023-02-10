package xyz.zhouzhaodong.springbootinterceptor.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.zhouzhaodong.springbootinterceptor.entity.User;

/**
 * @date: 2023/2/6 12:24
 * @author: zhouzhaodong
 * @description: 测试
 */
@RestController
public class TestController {

    @PostMapping("/one/abc")
    public String abc(@RequestBody User user){
        return user.getName();
    }

}
