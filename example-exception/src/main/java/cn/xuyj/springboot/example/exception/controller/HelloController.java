package cn.xuyj.springboot.example.exception.controller;

import cn.xuyj.springboot.example.exception.custom.IdNotExistException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/26 15:12
 */
@RestController
public class HelloController {
    @GetMapping("/{id}")
    public void get(@PathVariable String id) {
        throw new IdNotExistException(id);
    }
}
