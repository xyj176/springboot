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
    //只有当被拦截的方法没有抛出异常成功时才会处理
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("开始拦截");
        System.out.println("拦截处理。。。");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    //无论被拦截的方法抛出异常与否都会执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截完成");
        Long startTime = (Long) request.getAttribute("startTime");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("拦截器耗时：" + (new Date().getTime() - startTime) + "ms");
    }
}
