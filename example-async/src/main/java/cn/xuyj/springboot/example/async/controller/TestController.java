package cn.xuyj.springboot.example.async.controller;

import cn.xuyj.springboot.example.async.domain.User;
import cn.xuyj.springboot.example.async.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    @GetMapping("/async/return")
    public String testAsyncWithReturn() throws ExecutionException, InterruptedException {
        log.info("主线程开始");
        Future<String> future = service.asyncMethodWithReturn();
        String result = future.get();//get方法会阻塞主线程：只有当异步方法返回结果才会继续往下执行
        log.info("异步方法返回值：" + result);
        log.info("主线程结束");
        return result;
    }

    @GetMapping("/async/return/user")
    public User testAsyncWithReturn2() throws ExecutionException, InterruptedException {
        log.info("主线程开始");
        Future<User> future = service.asyncMethodWithReturn2();
        User result = future.get();//get方法会阻塞主线程：只有当异步方法返回结果才会继续往下执行
        log.info("异步方法返回值：" + result);
        log.info("主线程结束");
        return result;
    }
}
