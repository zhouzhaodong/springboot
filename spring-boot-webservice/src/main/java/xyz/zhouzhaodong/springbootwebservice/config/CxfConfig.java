package xyz.zhouzhaodong.springbootwebservice.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.zhouzhaodong.springbootwebservice.service.CommonService;

/**
 * cxf配置类
 * @author zhouzhaodong
 */
@Configuration
public class CxfConfig {
    @Autowired
    private Bus bus;

    @Autowired
    CommonService commonService;

    /** JAX-WS **/
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, commonService);
        //发布地址
        endpoint.publish("/CommonService");
        return endpoint;
    }
}
