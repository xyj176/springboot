package cn.xuyj.springboot.example.security.jwt.util;

import cn.xuyj.springboot.example.infrastructure.util.ExceptionUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: xuyj
 * @Date: 2025/5/17 12:12
 * @Email: 1768335576@qq.com
 * @Desc：类描述
 */
@Slf4j
@Component
public class JwtUtil {
    @Value("${jwt.secret:secret}")
    private String SECRET;
//    private static final long EXPIRATION_TIME = 86400000;//24小时
    private static final long EXPIRATION_TIME = 20000;//10秒

    /**
     * 生成token
     *
     * @param username
     * @return
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * 获取用户名
     *
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public boolean validateToken(String token) {
        try{
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        }catch (ExpiredJwtException e){
            throw new RuntimeException("【token已过期】："+ExceptionUtil.getMessage(e));
        }
        catch (Exception e){
            throw new RuntimeException("【token验证失败】："+ExceptionUtil.getMessage(e));
        }
        return true;
    }
}
