package cn.xuyj.springboot.example.mongodb;

import cn.xuyj.springboot.example.mongodb.service.MongodbService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: xuyj
 * @Date: 2025/2/8 19:37
 * @Email: 1768335576@qq.com
 * @Desc：类描述
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    MongodbService service;

    /**
     * 本地文件上传测试
     */
    @org.junit.Test
    public void test() {
        String local = "E:\\work\\code\\springboot\\tmp\\714af07b-0ac7-4734-8560-dc733135dee2\\上传测试.txt";
        Boolean upload = service.upload(local, "");
        System.out.println(upload);
    }
}
