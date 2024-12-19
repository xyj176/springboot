package cn.xuyj.springboot.example.async.service;

import cn.xuyj.springboot.example.async.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/12/19 13:24
 */
@Service
@Slf4j
public class TestService {
    //异步方法
    @Async
    public void asyncMethod() {
        log.info("异步线程开始");
        log.info("异步方法内部线程名称：" + Thread.currentThread().getName());
        sleep();
        log.info("异步线程结束");
    }

    //同步方法
    public void syncMethod() {
        sleep();
    }

    //指定线程池bean的名称，即可使用该线程池
    @Async("asyncThreadPoolTaskExecutor")
    public void asyncMethodWithThreadPool() {
        log.info("异步线程开始");
        log.info("异步方法内部线程名称：" + Thread.currentThread().getName());
        sleep();
        log.info("异步线程结束");
    }

    //异步方法具有返回值的话，需要使用Future来接收回调值
    @Async("asyncThreadPoolTaskExecutor")
    public Future<String> asyncMethodWithReturn() {
        log.info("异步线程开始");
        log.info("异步方法内部线程名称：" + Thread.currentThread().getName());
        sleep();
        log.info("异步线程结束");
        return new AsyncResult<>("hello async");
    }

    @Async("asyncThreadPoolTaskExecutor")
    public Future<User> asyncMethodWithReturn2() {
        log.info("异步线程开始");
        log.info("异步方法内部线程名称：" + Thread.currentThread().getName());
        sleep();
        User user = new User();
        user.setName("async");
        user.setAge(18);
        user.setSex("男");
        log.info("异步线程结束");
        return new AsyncResult<>(user);
    }

    //自定义私有方法
    private void sleep() {
        try {
            //线程阻塞2s
            log.info("休眠2秒");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
