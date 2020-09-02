package xyz.zhouzhaodong.querydsl.service;

import xyz.zhouzhaodong.querydsl.entity.People;

/**
 * service
 * @author zhouzhaodong
 */
public interface PeopleService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    People selectOne(Integer id);

}
