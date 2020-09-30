package xyz.zhouzhaodong.springbootwebservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author zhouzhaodong
 */
@WebService(name = "CommonService", // 暴露服务名称
        targetNamespace = "http://springbootwebservice.zhouzhaodong.xyz/"// 命名空间,一般是接口的包名倒序
)
public interface CommonService {

    /**
     * 暴露接口
     * @param name
     * @return
     */
    @WebMethod
    String sayHello(@WebParam(name = "userName") String name);

}
