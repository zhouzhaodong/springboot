package xyz.zhouzhaodong.springbootinterceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动类
 *
 * @author zhouzhaodong
 */
@ServletComponentScan
@SpringBootApplication
public class SpringbootInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootInterceptorApplication.class, args);
    }

}
