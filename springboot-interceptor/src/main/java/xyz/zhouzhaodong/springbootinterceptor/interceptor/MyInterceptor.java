package xyz.zhouzhaodong.springbootinterceptor.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date: 2023/2/6 11:19
 * @author: zhouzhaodong
 * @description: 实现HandlerInterceptor接口
 */

public class MyInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    /**
     * @date: 2023/2/6 11:19
     * @author: zhouzhaodong
     * @description: 访问控制器方法前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("================进入拦截器======================");
        logger.info(new Date() + "--preHandle:" + request.getRequestURL());
        logger.info("***************************【RequestBeginning】***************************");
        logger.info("----------------StartProcessingRequest----------------");
        try {
            long currentTime = System.currentTimeMillis();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date(currentTime);
            logger.info("CurrentTime: {}", formatter.format(date));
            logger.info("ResponseTime: {}", (System.currentTimeMillis() - currentTime) + "ms");
            String requestUrl = request.getRequestURI();
            logger.info("RequestURL: {} ", requestUrl);
            logger.info("GetMethod: {}", handler);
            String method = request.getMethod();
            logger.info("Method: {}", method);
            //获取请求参数
            RequestWrapper requestWrapper = new RequestWrapper(request);
            //这里getBodyString()方法无参数
            logger.info("RequestBody: {}", requestWrapper.getBodyString());
        } catch (Exception e) {
            logger.error("MVC业务处理-拦截器异常：", e);
        }
        logger.info("-------------------------End-------------------------");
        return true;
    }

    /**
     * @date: 2023/2/6 12:46
     * @author: zhouzhaodong
     * @description: 访问控制器方法后执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        logger.info(new Date() + "--postHandle:" + request.getRequestURL());
    }

    /**
     * @date: 2023/2/6 12:46
     * @author: zhouzhaodong
     * @description: postHandle方法执行完成后执行，一般用于释放资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        logger.info(new Date() + "--afterCompletion:" + request.getRequestURL());
    }
}