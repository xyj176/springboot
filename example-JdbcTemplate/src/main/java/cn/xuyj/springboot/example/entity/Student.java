package cn.xuyj.springboot.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuyj
 * @since 2024/7/15 14:44
 */
@Data
public class Student implements Serializable {
    private String id;
    private String name;
    private String sex;
}
