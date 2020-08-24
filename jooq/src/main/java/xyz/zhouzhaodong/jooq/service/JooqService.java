package xyz.zhouzhaodong.jooq.service;


import xyz.zhouzhaodong.jooq.entity.JooqPojo;

/**
 * @author zhouzhaodong
 */
public interface JooqService {

    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    JooqPojo selectByName(String name);

}
