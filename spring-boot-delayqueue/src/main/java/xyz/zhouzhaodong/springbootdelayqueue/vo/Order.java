package xyz.zhouzhaodong.springbootdelayqueue.vo;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 订单类
 * @author zhouzhaodong
 */
public class Order implements Delayed {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 订单状态（0待支付，1已支付，2已取消）
     */
    private Integer status;

    /**
     * 订单创建时间
     */
    private Date createTime;

    /**
     * 订单取消时间
     */
    private Date cancelTime;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public Order(String orderNo, String userId, Integer status, Date createTime, Date cancelTime) {
        this.orderNo = orderNo;
        this.userId = userId;
        this.status = status;
        this.createTime = createTime;
        this.cancelTime = cancelTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", userId='" + userId + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", cancelTime=" + cancelTime +
                '}';
    }

    /**
     * 获得延迟时间，用过期时间-当前时间，时间单位需要统一
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        //下面用到unit.convert()方法，其实在这个小场景不需要用到，只是学习一下如何使用罢了
        return unit.convert(cancelTime.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    /**
     * 用于延迟队列内部比较排序，当前时间的延迟时间 - 比较对象的延迟时间
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        //这里根据取消时间来比较，如果取消时间小的，就会优先被队列提取出来
        return this.getCancelTime().compareTo(((Order) o).getCancelTime());
    }
}
