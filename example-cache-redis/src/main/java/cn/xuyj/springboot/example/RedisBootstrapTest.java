package cn.xuyj.springboot.example;

import cn.xuyj.springboot.example.bean.Student;
import cn.xuyj.springboot.example.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xuyj
 * @since 2024/7/17 15:45
 */
@SpringBootTest(classes = RedisBootstrap.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisBootstrapTest {
    @Autowired
    StudentService service;

    @Test
    public void test() throws Exception {
        Student student1 = this.service.query("001");
        System.out.println("学号" + student1.getId() + "的学生姓名为：" + student1.getName());

        student1.setName("康康");
        service.update(student1);

        Student student2 = this.service.query("001");
        System.out.println("学号" + student2.getId() + "的学生姓名为：" + student2.getName());
    }
}
