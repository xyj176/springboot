package cn.xuyj.springboot.example.async.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/12/19 14:19
 */
@Data
public class User implements Serializable {
    private String name;

    private int age;

    private String sex;
}
