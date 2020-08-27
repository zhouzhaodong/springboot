package xyz.zhouzhaodong.html2image.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zhouzhaodong.html2image.util.Html2Image;

/**
 * 控制层
 *
 * @author zhouzhaodong
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String message(){
        return Html2Image.html2Img("./m.jpg");
    }

}
