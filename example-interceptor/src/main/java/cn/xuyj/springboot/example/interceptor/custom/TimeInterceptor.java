package cn.xuyj.springboot.example.interceptor.custom;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/12/10 11:27
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截前");
        request.setAttribute("startTime", new Date().getTime());
        System.out.println("拦截的类：" + ((HandlerMethod) handler).getBean().getClass().getName());
        System.out.println("拦截的方法：" + ((HandlerMethod) handler).getMethod().getName());
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("开始拦截");
        System.out.println("拦截处理。。。");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截完成");
        Long startTime = (Long) request.getAttribute("startTime");
        System.out.println("拦截器耗时：" + (new Date().getTime() - startTime) + "ms");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
