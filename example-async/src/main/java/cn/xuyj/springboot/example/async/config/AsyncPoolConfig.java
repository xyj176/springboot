package cn.xuyj.springboot.example.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author xuyj
 * @des 自定义线程池
 * @since 2024/12/19 13:47
 */
@Configuration
public class AsyncPoolConfig {
    @Bean
    public ThreadPoolTaskExecutor asyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数量，默认是1
        executor.setCorePoolSize(20);
        //最大线程数量。核心线程和缓冲队列已满，则会开始申请新线程
        executor.setMaxPoolSize(200);
        //缓冲队列数
        executor.setQueueCapacity(25);
        //线程空闲的最大存活时间，单位秒
        executor.setKeepAliveSeconds(200);
        //线程名前缀
        executor.setThreadNamePrefix("asyncThread——");
        //是否等待所有线程执行完毕才关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //waitForTasksToCompleteOnShutdown的等待时间，单位秒
        executor.setAwaitTerminationSeconds(60);

        //当没有线程可以被使用时的处理策略，默认是abortPolicy策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//callerRunsPolicy:在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());//abortPolicy:直接抛出java.util.concurrent.RejectedExecutionException异常
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());//discardOldestPolicy:当线程池中的数量等于最大线程数时、抛弃线程池中最后一个要执行的任务，并执行新传入的任务
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());//discardPolicy:当线程池中的数量等于最大线程数时，不做任何动作

        executor.initialize();
        return executor;
    }
}
