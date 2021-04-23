package com.example.mongodb.repository;

import com.example.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, Integer> {

    /**
     * 根据姓名进行查询
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     * 根据姓名进行模糊查询
     * @param name
     * @return
     */
    List<User> findByNameLike(String name);

}
