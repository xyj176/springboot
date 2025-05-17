package cn.xuyj.springboot.example.security.jwt.filter;

import cn.xuyj.springboot.example.infrastructure.response.ControllerResponseData;
import cn.xuyj.springboot.example.infrastructure.util.ExceptionUtil;
import cn.xuyj.springboot.example.security.jwt.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: xuyj
 * @Date: 2025/5/17 12:59
 * @Email: 1768335576@qq.com
 * @Desc：类描述
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try{
            String token = extractToken(httpServletRequest);
            if (token != null && jwtUtil.validateToken(token)) {
                String username = jwtUtil.getUsernameFromToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                //设置security上下文
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }catch (Exception e){
            //filter中的异常无法被@RestControllerAdvice捕获，所以需要手动返回
            String message = ExceptionUtil.getMessage(e);
            httpServletResponse.setCharacterEncoding("UTF-8"); // 设置字符集
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(ControllerResponseData.fail(message)));
        }

    }

    /**
     * 提取token
     * @param request
     * @return
     */
    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
