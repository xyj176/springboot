package cn.xuyj.springboot.example.validator.controller;

import cn.xuyj.springboot.example.validator.domain.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/12/10 13:28
 */
@RestController
@Validated
public class TestController {

    @GetMapping("/test")
    public String test(@NotBlank(message = "不能为空") String name,
                       @Email(message = "格式不正确") String email) {
        return name + email;
    }

    @PostMapping("/test2")
    public String test2(@Valid @RequestBody User user) {
        return user.getName() + user.getEmail();
    }
}
