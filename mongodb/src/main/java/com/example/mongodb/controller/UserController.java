package com.example.mongodb.controller;

import com.example.mongodb.entity.User;
import com.example.mongodb.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    UserRepository userRepository;

    /**
     * 新增
     * @param user
     * @return
     */
    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("/user")
    public void saveUser(Integer id){
        userRepository.deleteById(id);
    }

    /**
     * 修改
     * @param user
     */
    @PutMapping("/user")
    public void updateUser(@RequestBody User user){
        userRepository.save(user);
    }

    /**
     * 根据名字精准匹配
     * @param name
     * @return
     */
    @GetMapping("/userByName")
    public User userByName(String name){
        return userRepository.findByName(name);
    }

    /**
     * 根据名字模糊查询
     * @param name
     * @return
     */
    @GetMapping("/userList")
    public List<User> userList(String name){
        return userRepository.findByNameLike(name);
    }

}
