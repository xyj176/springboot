package cn.xuyj.springboot.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xuyj
 * @since 2024/8/22 23:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;
    private String password;
}
