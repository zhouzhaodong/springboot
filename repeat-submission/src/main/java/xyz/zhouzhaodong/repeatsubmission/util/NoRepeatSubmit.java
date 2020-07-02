package xyz.zhouzhaodong.repeatsubmission.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义一个注解
 * @apiNote @Target(ElementType.METHOD) 作用到方法上
 * @apiNote @Retention(RetentionPolicy.RUNTIME) 只有运行时有效
 * @author zhouzhaodong
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoRepeatSubmit {

}
