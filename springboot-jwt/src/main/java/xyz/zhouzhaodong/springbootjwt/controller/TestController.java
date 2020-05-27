package xyz.zhouzhaodong.springbootjwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.zhouzhaodong.springbootjwt.util.JwtUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * 登陆
 * @author zhouzhaodong
 */
@RestController
public class TestController {

    @RequestMapping("/login")
    public String login(HttpServletResponse response, String userName, String passWord) {
        // 假装判断一下登陆是否成功
        if(userName == null || "".equals(userName) || passWord == null || "".equals(passWord)){
            return "用户名或者密码不能为空";
        }
        String token = JwtUtils.geneJsonWebToken(userName, passWord);
        // 将token放在响应头
        response.setHeader("Authorization", token);
        return token;
    }

    @RequestMapping("/secure/check")
    public String check(){
        return "登陆成功";
    }

}
