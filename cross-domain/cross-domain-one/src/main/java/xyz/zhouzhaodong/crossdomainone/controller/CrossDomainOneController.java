package xyz.zhouzhaodong.crossdomainone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跨域8080端口方法
 * @author zhouzhaodong
 */
@Controller
public class CrossDomainOneController {

    @RequestMapping("/")
    public String index(){
        return "cross-domain-one";
    }

}
