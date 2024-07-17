package cn.xuyj.springboot.example.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuyj
 * @since 2024/7/17 15:19
 */
@Data
public class Student implements Serializable {
    private String id;
    private String name;
    private String sex;
}
