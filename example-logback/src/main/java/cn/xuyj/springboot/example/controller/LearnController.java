package cn.xuyj.springboot.example.controller;

import cn.xuyj.springboot.example.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuyj
 * @since 2024/8/22 23:32
 */
@RestController
public class LearnController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/login")
    public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        Map<String, Object> map = new HashMap<String, Object>();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (!userName.equals("") && password != "") {
            User user = new User(userName, password);
            request.getSession().setAttribute("user", user);
            map.put("result", "1");
        } else {
            map.put("result", "0");
        }
        return map;
    }
}
