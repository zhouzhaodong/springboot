package xyz.zhouzhaodong.springbootureport2.config;

import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.Servlet;

/**
 * springboot实体类配置
 *
 * @author zhouzhaodong
 */
@ImportResource("classpath:context.xml")
@Configuration
public class BeanConfig {

    @Bean
    public ServletRegistrationBean<Servlet> ureport2Servlet() {
        return new ServletRegistrationBean<>(new UReportServlet(), "/ureport/*");
    }

}
