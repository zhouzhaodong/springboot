package xyz.zhouzhaodong.springbootdelayqueue.service.impl;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import xyz.zhouzhaodong.springbootdelayqueue.service.CancelOrderService;
import xyz.zhouzhaodong.springbootdelayqueue.vo.Order;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * 取消订单实现类
 *
 * @author zhouzhaodong
 */
@Service
public class CancelOrderServiceImpl implements CancelOrderService {

    /**
     * 是否开启自动取消功能
     */
    @Value("${order.isStarted}")
    private int isStarted;

    /**
     * 延迟队列，用来存放订单对象
     */
    DelayQueue<Order> queue = new DelayQueue<>();

    @Resource
    private ThreadPoolTaskExecutor executorService;

    @Override
    public void cancelOrder() {
        //新建一个线程，用来模拟定时取消订单job
        executorService.submit(()->{
            try {
                System.out.println("开启自动取消订单job,当前时间：" + DateUtil.date());
                while (isStarted == 1) {
                    try {
                        Order order = queue.take();
                        order.setStatus(2);
                        System.out.println("订单：" + order.getOrderNo() + "付款超时，自动取消，当前时间：" + DateUtil.date());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public DelayQueue<Order> getOrder(){
        executorService.submit(()->{
            try {
                Date date = DateUtil.date();
                queue.add(new Order("SO001", "001", 0, date, DateUtil.offset(date, DateField.SECOND, 3)));
                queue.add(new Order("SO002", "002", 0, DateUtil.offset(date, DateField.SECOND, 3), DateUtil.offset(date, DateField.SECOND, 6)));
                queue.add(new Order("SO003", "003", 0, DateUtil.offset(date, DateField.SECOND, 6), DateUtil.offset(date, DateField.SECOND, 9)));
                queue.add(new Order("SO004", "004", 0, DateUtil.offset(date, DateField.SECOND, 9), DateUtil.offset(date, DateField.SECOND, 12)));
                queue.add(new Order("SO005", "005", 0, DateUtil.offset(date, DateField.SECOND, 12), DateUtil.offset(date, DateField.SECOND, 15)));
                queue.add(new Order("SO006", "006", 0, DateUtil.offset(date, DateField.SECOND, 15), DateUtil.offset(date, DateField.SECOND, 18)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return queue;
    }
}
