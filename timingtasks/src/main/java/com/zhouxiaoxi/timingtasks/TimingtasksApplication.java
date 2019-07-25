package com.zhouxiaoxi.timingtasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 定时任务
 * @author zhouzhaodong
 */
@SpringBootApplication
@EnableScheduling
public class TimingtasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimingtasksApplication.class, args);
    }

}
