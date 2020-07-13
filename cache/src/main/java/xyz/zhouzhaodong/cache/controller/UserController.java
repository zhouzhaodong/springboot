package xyz.zhouzhaodong.cache.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zhouzhaodong.cache.entity.User;
import xyz.zhouzhaodong.cache.service.UserService;

import javax.annotation.Resource;

/**
 * 控制层
 * @author zhouzhaodong
 */
@RestController
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/save")
    public User saveUser(User user){
        return userService.insert(user);
    }

    @RequestMapping("/delete")
    public void deleteUser(int id){
        userService.delete(id);
    }

    @RequestMapping("/update")
    public User updateUser(User user){
        return userService.update(user);
    }

    @RequestMapping("/find")
    public Object findById(int id){
        return userService.findById(id);
    }

}
