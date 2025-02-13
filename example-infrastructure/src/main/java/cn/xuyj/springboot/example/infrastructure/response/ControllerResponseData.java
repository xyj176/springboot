package cn.xuyj.springboot.example.infrastructure.response;

import lombok.Data;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/13 14:15
 */
@Data
public class ControllerResponseData<T> {

    private static final String SUCCESS_STATUS = "success";
    private static final Integer SUCCESS_CODE = 100;

    private static final String FAIL_STATUS = "fail";
    private static final Integer FAIL_CODE = -1;

    private Integer code;
    private String status;
    private String message;
    private T data;

    public static <T> ControllerResponseData<T> success(T data) {
        ControllerResponseData<T> result = new ControllerResponseData<>();
        result.setData(data);
        result.setCode(SUCCESS_CODE);
        result.setStatus(SUCCESS_STATUS);
        return result;
    }

    public static <T> ControllerResponseData<T> fail(String message) {
        ControllerResponseData<T> result = new ControllerResponseData<>();
        result.setCode(FAIL_CODE);
        result.setStatus(FAIL_STATUS);
        result.setMessage(message);
        return result;
    }
}
