package xyz.zhouzhaodong.repeatsubmission.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 自定义一个切面类，利用aspect实现切入所有方法
 *
 * @author zhouzhaodong
 */
@Aspect
@Configuration
public class NoRepeatSubmitAop {

    private final Log logger = LogFactory.getLog(getClass());

    /**
     * 重复提交判断时间为2s
     */
    private final Cache<String, Integer> cache = CacheBuilder.newBuilder().expireAfterWrite(2L, TimeUnit.SECONDS).build();

    @Around("execution(* xyz.zhouzhaodong..*Controller.*(..)) && @annotation(nrs)")
    public Object around(ProceedingJoinPoint pjp, NoRepeatSubmit nrs) {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String sessionId = Objects.requireNonNull(RequestContextHolder.getRequestAttributes()).getSessionId();
            assert attributes != null;
            HttpServletRequest request = attributes.getRequest();
            String key = sessionId + "-" + request.getServletPath();
            // 如果缓存中有这个url视为重复提交
            if (cache.getIfPresent(key) == null) {
                Object o = pjp.proceed();
                cache.put(key, 0);
                return o;
            } else {
                logger.error("重复提交");
                return new RestMessage(888, "请勿短时间内重复操作");
            }
        } catch (Throwable e) {
            e.printStackTrace();
            logger.error("验证重复提交时出现未知异常!");
            return new RestMessage(889, "验证重复提交时出现未知异常!");
        }

    }

}
