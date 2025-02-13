package cn.xuyj.springboot.example.infrastructure.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author xuyj
 * @des 捕获接口的返回
 * @since 2025/2/13 14:34
 */
@RestControllerAdvice
public class ControllerResponseAdvice implements ResponseBodyAdvice {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //针对返回值是字符串的
        if (body instanceof String)
            return objectMapper.writeValueAsString(ControllerResponseData.success(body));
        //针对异常捕获的
        if (body instanceof ControllerResponseData)
            return body;
        //接口成功调用的
        return ControllerResponseData.success(body);
    }
}
