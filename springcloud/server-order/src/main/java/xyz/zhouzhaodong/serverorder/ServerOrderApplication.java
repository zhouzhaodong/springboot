package xyz.zhouzhaodong.serverorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者启动类
 * @author zhouzhaodong
 */
@EnableEurekaClient
@SpringBootApplication
public class ServerOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerOrderApplication.class, args);
	}

}
