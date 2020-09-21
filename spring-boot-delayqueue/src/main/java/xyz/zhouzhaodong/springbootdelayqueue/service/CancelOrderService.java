package xyz.zhouzhaodong.springbootdelayqueue.service;

import xyz.zhouzhaodong.springbootdelayqueue.vo.Order;

import java.util.concurrent.DelayQueue;

/**
 * 取消订单service类
 * @author zhouzhaodong
 */
public interface CancelOrderService {

    /**
     * 取消订单
     */
    void cancelOrder();

    /**
     * 获取队列
     * @return
     */
    DelayQueue<Order> getOrder();

}
