package com.zhouxiaoxi.timingtasks.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 * @author zhouzhaodong
 */
@Component
public class TimingTasks {

    private static final Logger logger = LoggerFactory.getLogger(TimingTasks.class);

    /**
     * 定时打印时间
     */
    @Scheduled(fixedRate = 5000)
    public void printCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        logger.info("现在的时间为：{}",time);
    }

}
