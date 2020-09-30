package xyz.zhouzhaodong.springbootwebservice.service.impl;

import org.springframework.stereotype.Component;
import xyz.zhouzhaodong.springbootwebservice.service.CommonService;

import javax.jws.WebService;

/**
 * @author zhouzhaodong
 */
@WebService(serviceName = "CommonService", // 与接口中指定的name一致
        targetNamespace = "http://springbootwebservice.zhouzhaodong.xyz/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "xyz.zhouzhaodong.springbootwebservice.service.CommonService"// 接口地址
)
@Component
public class CommonServiceImpl implements CommonService {

    @Override
    public String sayHello(String name) {
        return "HELLO" + name;
    }
}
