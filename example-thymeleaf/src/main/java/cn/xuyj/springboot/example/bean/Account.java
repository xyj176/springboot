package cn.xuyj.springboot.example.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xuyj
 * @since 2024/7/16 15:36
 */
@Data
@AllArgsConstructor
public class Account {
    private String account;
    private String name;
    private String password;
    private String accountType;
    private String tel;
}
