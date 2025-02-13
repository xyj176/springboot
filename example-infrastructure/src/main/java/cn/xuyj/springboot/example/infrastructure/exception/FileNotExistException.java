package cn.xuyj.springboot.example.infrastructure.exception;

import lombok.Data;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/13 17:02
 */
@Data
public class FileNotExistException extends RuntimeException {
    private static final long serialVersionUID = 3393927506848336568L;
    private String fileName;

    public FileNotExistException(String fileName) {
        super("指定的文件【" + fileName + "】不存在");
        this.fileName = fileName;
    }
}
