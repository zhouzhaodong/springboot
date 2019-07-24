package com.zhouxiaoxi.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * redis访问层
 * @author zhouzhaodong
 */
@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;

    /**
     * 新增redis缓存
     * @param key
     * @param value
     */
    public void setKey(String key, String value){
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key,value,1);
    }

    /**
     * 获取对应key的缓存
     * @param key
     * @return
     */
    public String getValue(String key){
        ValueOperations<String, String> ops = template.opsForValue();
        return ops.get(key);
    }

    /**
     * 删除对应key的缓存
     * @param key
     * @return
     */
    public void delValue(String key){
        template.delete(key);
    }

}
