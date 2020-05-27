package xyz.zhouzhaodong.springbootjwt.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * JWT生成类
 * @author zhouzhaodong
 */
public class JwtUtils {

    public static final String SUBJECT = "admin";

    /**
     * 过期时间，毫秒，一天
     */
    public static final long EXPIRE = 1000 * 60 * 60 * 24;

    /**
     * 秘钥
     */
    public static final String SECRET_KEY = "secretkey";

    /**
     * 生成jwt
     * @param userName
     * @param passWord
     * @return
     */
    public static String geneJsonWebToken(String userName, String passWord) {

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)) {
            return "用户名或密码不能为空";
        }

        return Jwts.builder().setSubject(SUBJECT)
                .claim("userName", userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

}
