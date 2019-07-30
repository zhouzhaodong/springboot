package com.zhouxiaoxi.timingtasks.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 * @author zhouzhaodong
 */
@Component
@Slf4j
public class TimingTasks {

    /**
     * 定时打印时间
     */
    @Scheduled(fixedRate = 5000)
    public void printCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        log.info("现在的时间为：{}",time);
    }

}
