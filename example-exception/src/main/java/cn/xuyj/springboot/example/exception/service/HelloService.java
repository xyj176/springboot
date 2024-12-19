package cn.xuyj.springboot.example.exception.service;

import cn.xuyj.springboot.example.exception.custom.IdNotExistException;
import org.springframework.stereotype.Service;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/12/19 15:06
 */
@Service
public class HelloService {

    public void hello(String id) {
        throw new IdNotExistException(id);
    }
}
