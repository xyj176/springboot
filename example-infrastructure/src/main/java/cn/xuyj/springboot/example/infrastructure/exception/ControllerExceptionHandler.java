package cn.xuyj.springboot.example.infrastructure.exception;

import cn.xuyj.springboot.example.infrastructure.response.ControllerResponseData;
import cn.xuyj.springboot.example.infrastructure.util.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author xuyj
 * @des 异常捕获类
 * @since 2025/2/13 14:48
 */
@RestControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ControllerResponseData handleDefaultException(Exception e) {
        String message = ExceptionUtil.getMessage(e);
        log.error("全局异常信息：" + message);
        return ControllerResponseData.fail(message);
    }

    @ExceptionHandler(FileNotExistException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ControllerResponseData handleFileNotExistException(FileNotExistException e) {
        String message = ExceptionUtil.getMessage(e);
        log.error(message);
        return ControllerResponseData.fail(message);
    }
}
