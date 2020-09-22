package xyz.zhouzhaodong.springbooth2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zhouzhaodong.springbooth2.dao.UserDao;
import xyz.zhouzhaodong.springbooth2.entity.User;

import javax.annotation.Resource;

/**
 * 控制层
 * @author zhouzhaodong
 */
@RestController
public class UserController {

    @Resource
    UserDao userDao;

    @RequestMapping("/findById")
    public Object findById(Integer id){
        return userDao.findById(id);
    }

    @RequestMapping("/insert")
    public void insert(User user){
        userDao.save(user);
    }

    @RequestMapping("/delete")
    public void delete(Integer id){
        userDao.deleteById(id);
    }

}
