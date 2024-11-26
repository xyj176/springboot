package cn.xuyj.springboot.example.exception.custom;

import lombok.Data;

/**
 * @author xuyj
 * @des 自定义的异常类
 * @since 2024/11/26 15:20
 */
@Data
public class IdNotExistException extends RuntimeException{

    private static final long serialVersionUID = 2738716652652563745L;

    private String id;

    public IdNotExistException(String id) {
        super("id not exist");
        this.id = id;
    }
}
