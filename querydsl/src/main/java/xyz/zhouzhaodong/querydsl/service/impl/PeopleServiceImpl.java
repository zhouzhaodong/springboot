package xyz.zhouzhaodong.querydsl.service.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Service;
import xyz.zhouzhaodong.querydsl.entity.People;
import xyz.zhouzhaodong.querydsl.entity.QPeople;
import xyz.zhouzhaodong.querydsl.service.PeopleService;

import javax.annotation.Resource;

/**
 * serviceImpl
 * @author zhouzhaodong
 */
@Service
public class PeopleServiceImpl implements PeopleService {

    @Resource
    JPAQueryFactory queryFactory;

    @Override
    public People selectOne(Integer id) {
        QPeople people = QPeople.people;
        return queryFactory.selectFrom(people).where(people.id.eq(id)).fetchOne();
    }
}
