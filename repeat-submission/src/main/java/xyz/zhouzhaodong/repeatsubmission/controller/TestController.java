package xyz.zhouzhaodong.repeatsubmission.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zhouzhaodong.repeatsubmission.util.NoRepeatSubmit;
import xyz.zhouzhaodong.repeatsubmission.util.RestMessage;

/**
 * 测试
 * @author zhouzhaodong
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 添加防重复提交注解
     * @return
     */
    @NoRepeatSubmit
    @RequestMapping("/one")
    public RestMessage test(){
        return new RestMessage(0, "测试通过");
    }

}
