package xyz.zhouzhaodong.serveruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者
 * @author zhouzhaodong
 */
@EnableEurekaClient
@SpringBootApplication
public class ServerUserApplication {

	/**
	 * @Bean 注解用来注入restTemplate
	 * @LoadBalanced 注解用来在注册中心里进行查找微服务,Ribbon负载均衡
	 * 生成一个RestTemplate实例对象
	 * 使用user服务调用order服务就是通过这个restTemplate对象实现的
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServerUserApplication.class, args);
	}

}
