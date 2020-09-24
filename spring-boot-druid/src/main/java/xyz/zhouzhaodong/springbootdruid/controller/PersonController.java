package xyz.zhouzhaodong.springbootdruid.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zhouzhaodong.springbootdruid.entity.Person;
import xyz.zhouzhaodong.springbootdruid.jpa.PersonRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhouzhaodong
 */
@RestController
public class PersonController {

    @Resource
    PersonRepository personRepository;

    @RequestMapping("/getAll")
    public List<Person> getAll(){
        return personRepository.findAll();
    }

}
