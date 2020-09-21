package xyz.zhouzhaodong.springbootdelayqueue.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zhouzhaodong.springbootdelayqueue.service.CancelOrderService;

import javax.annotation.Resource;

/**
 * 控制器
 * @author zhouzhaodong
 */
@RestController
public class CancelOrderController {

    @Resource
    CancelOrderService cancelOrderService;

    @RequestMapping("/")
    public void cancelOrder(){
        cancelOrderService.getOrder();
        cancelOrderService.cancelOrder();
    }

    @RequestMapping("/queue")
    public void getOrder(){
        cancelOrderService.getOrder();
    }

}
