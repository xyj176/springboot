package cn.xuyj.springboot.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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
