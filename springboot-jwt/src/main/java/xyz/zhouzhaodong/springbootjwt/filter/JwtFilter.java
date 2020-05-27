package xyz.zhouzhaodong.springbootjwt.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截器验证类
 * @author zhouzhaodong
 */
public class JwtFilter extends GenericFilterBean {

    /**
     * 秘钥
     */
    public static final String SECRET_KEY = "secretkey";

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        // 从request中获取authorization
        final String authHeader = request.getHeader("authorization");

        // 如果Http请求是OPTIONS，那么只需返回状态代码200即可。
        String options = "OPTIONS";
        if (options.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else {

            // 判断token是否是用Bearer 开头的
            String header = "Bearer ";
            if (authHeader == null || !authHeader.startsWith(header)) {
                throw new ServletException("Missing or invalid Authorization header");
            }

            // 然后从授权处获取JWT令牌
            final String token = authHeader.substring(7);

            try {
                // 使用JWT解析器检查签名是否与Key "secretkey "有效。
                final Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();

                // 在请求标题中添加claims
                request.setAttribute("claims", claims);
            } catch (final SignatureException e) {
                throw new ServletException("Invalid token");
            }

        }
        chain.doFilter(req, res);
    }
}
