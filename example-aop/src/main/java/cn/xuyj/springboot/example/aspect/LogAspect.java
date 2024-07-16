package cn.xuyj.springboot.example.aspect;

import cn.xuyj.springboot.example.annotation.Log;
import cn.xuyj.springboot.example.dao.SysLogDao;
import cn.xuyj.springboot.example.domain.SysLog;
import cn.xuyj.springboot.example.util.HttpContextUtils;
import cn.xuyj.springboot.example.util.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author xuyj
 * @since 2024/7/16 11:00
 */
@Aspect
@Component
public class LogAspect {
    @Autowired
    SysLogDao sysLogDao;

    @Pointcut("@annotation(cn.xuyj.springboot.example.annotation.Log)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long begin = System.currentTimeMillis();
        try {
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        saveLog(point, end - begin);
        return result;
    }

    private void saveLog(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            //注解上的描述
            sysLog.setOperation(logAnnotation.value());
        }
        //请求的方法
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        //请求的方法参数
        Object[] args = point.getArgs();
        String[] parameterNames = new LocalVariableTableParameterNameDiscoverer().getParameterNames(method);
        if (args != null && parameterNames != null) {
            String params = "";
            //拼接参数名称和参数值
            for (int i = 0; i < args.length; i++) {
                params += " " + parameterNames[i] + ":" + args[i];
            }
            sysLog.setParams(params);
        }
        //设置ip
        HttpServletRequest httpServletRequest = HttpContextUtils.getHttpServletRequest();
        sysLog.setIp(IPUtils.getIpAddr(httpServletRequest));
        //模拟一个用户名
        sysLog.setUsername("xuyj");
        sysLog.setTime((int) time);
        sysLog.setCreateTime(new Date());
        //保存
        sysLogDao.save(sysLog);
    }
}
