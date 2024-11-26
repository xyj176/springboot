package cn.xuyj.springboot.example.exception.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuyj
 * @des 自定义异常处理类
 * @since 2024/11/26 15:26
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IdNotExistException.class)//指定处理的异常类型
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//指定异常返回的状态码
    public Map<String, Object> handleIdNotExistException(IdNotExistException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", e.getId());
        map.put("message", e.getMessage());
        return map;
    }
}
