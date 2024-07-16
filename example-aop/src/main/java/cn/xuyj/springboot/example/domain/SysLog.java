package cn.xuyj.springboot.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xuyj
 * @since 2024/7/16 10:39
 */
@Data
public class SysLog implements Serializable {
    private Integer id;
    private String username;
    private String operation;
    private Integer time;
    private String method;
    private String params;
    private String ip;
    private Date createTime;
}
