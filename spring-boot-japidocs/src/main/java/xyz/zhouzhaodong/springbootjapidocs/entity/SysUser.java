package xyz.zhouzhaodong.springbootjapidocs.entity;

import io.github.yedaxia.apidocs.Ignore;
import lombok.Data;

/**
 * @author zhouzhaodong
 */
@Data
public class SysUser {

    /**
     * id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 地址
     */
    private String address;

    /**
     * 测试字段
     * @Ignore 该注解在生成文档的时候会被忽略掉
     */
    @Ignore
    private String balabala;

}
