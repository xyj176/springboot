package cn.xuyj.springboot.example.filter.custom;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

/**
 * @author xuyj
 * @des 自定义过滤器, 这个过滤器的作用是计算接口执行的时间
 * @since 2024/12/10 10:42
 */
@Component
//属性配置了哪些请求可以进入该过滤器，/*表示所有请求
@WebFilter(urlPatterns = {"/*"})
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("开始执行过滤器");
        long start = new Date().getTime();
        chain.doFilter(request, response);
        System.out.println("过滤器执行耗时：" + (new Date().getTime() - start) + "ms");
        System.out.println("过滤器执行结束");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
        Filter.super.destroy();
    }
}
