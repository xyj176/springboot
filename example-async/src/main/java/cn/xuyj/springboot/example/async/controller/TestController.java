package cn.xuyj.springboot.example.async.controller;

import cn.xuyj.springboot.example.async.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/12/19 13:36
 */
@RestController
@Slf4j
public class TestController {
    @Autowired
    TestService service;

    @GetMapping("/async")
    public void testAsync() {
        log.info("主线程开始");
        service.asyncMethod();
        log.info("主线程结束");
    }

    @GetMapping("/sync")
    public void testSync() {
        log.info("主线程开始");
        service.syncMethod();
        log.info("主线程结束");
    }

    @GetMapping("/async/threadPool")
    public void testAsyncWithThreadPool() {
        log.info("主线程开始");
        service.asyncMethodWithThreadPool();
        log.info("主线程结束");
    }
}
