package xyz.zhouzhaodong.serveruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 消费者
 *
 * @author zhouzhaodong
 */
@RestController
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 返回值类型需要和我们的业务返回值一致
     * @return
     */
    @RequestMapping("getUserOrder")
    public String getUserOrder() {
        String url = "http://service-order/order/getMessage";
        return restTemplate.getForObject(url, String.class);
    }

}
