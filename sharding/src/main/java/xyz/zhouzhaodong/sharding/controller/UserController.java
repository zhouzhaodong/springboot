package xyz.zhouzhaodong.sharding.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zhouzhaodong.sharding.entity.User;
import xyz.zhouzhaodong.sharding.service.UserService;

import javax.annotation.Resource;

/**
 * 控制层
 *
 * @author zhouzhaodong
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/users")
    public Object list() {
        return userService.list();
    }

    @PostMapping("/add")
    public Object add(String name, String city) {
        User user = new User();
        user.setCity(city);
        user.setName(name);
        return userService.addUser(user);
    }

}
