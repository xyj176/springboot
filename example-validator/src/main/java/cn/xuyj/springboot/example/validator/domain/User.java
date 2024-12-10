package cn.xuyj.springboot.example.validator.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/12/10 14:04
 */
@Data
public class User {
    @NotBlank(message = "不能为空")
    private String name;

    @Email(message = "格式不正确")
    private String email;
}
