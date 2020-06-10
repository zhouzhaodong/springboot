package xyz.zhouzhaodong.springbootjwt.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 拦截器
 * @author zhouzhaodong
 */
@Configuration
public class JwtCfg {

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter() {
        final FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtFilter());
        // 对/test/*下的url进行拦截验证
        registrationBean.addUrlPatterns("/**");
        // 忽略某些url
        registrationBean.addInitParameter("exclusions","/update/*,/login");
        return registrationBean;
    }

}
