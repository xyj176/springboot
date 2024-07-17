package cn.xuyj.springboot.example;

import cn.xuyj.springboot.example.bean.Student;
import cn.xuyj.springboot.example.service.StudentService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xuyj
 * @since 2024/7/17 15:45
 */
@SpringBootTest(classes = CacheBootstrap.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CacheBootstrapTest {
    @Autowired
    StudentService service;

    @Test
    public void test() throws Exception {
        Student student1 = this.service.query("001");
        System.out.println("学号" + student1.getId() + "的学生姓名为：" + student1.getName());

        Student student2 = this.service.query("001");
        System.out.println("学号" + student2.getId() + "的学生姓名为：" + student2.getName());
    }
}
