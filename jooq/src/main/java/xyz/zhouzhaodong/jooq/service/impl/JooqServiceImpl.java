package xyz.zhouzhaodong.jooq.service.impl;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.zhouzhaodong.jooq.dao.tables.Jooq;
import xyz.zhouzhaodong.jooq.entity.JooqPojo;
import xyz.zhouzhaodong.jooq.service.JooqService;

import javax.annotation.Resource;

/**
 * @author zhouzhaodong
 */
@Service
public class JooqServiceImpl implements JooqService {

    @Resource
    DSLContext dslContext;

    Jooq jooq = Jooq.JOOQ_.as("jooq");

    @Override
    public JooqPojo selectByName(String name) {
        return dslContext.select()
                .from(jooq)
                .where(jooq.NAME.eq(name)).fetchAny(r -> r.into(JooqPojo.class));
    }
}
