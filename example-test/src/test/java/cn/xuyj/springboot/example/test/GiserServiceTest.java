package cn.xuyj.springboot.example.test;

import cn.xuyj.springboot.example.test.domain.Giser;
import cn.xuyj.springboot.example.test.service.GiserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/15 13:59
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GiserServiceTest {
    @Autowired
    GiserService service;

    @Test
    public void testFindByName() {
        String name = "xuyj";
        Giser giser = service.findByName(name);
        Assert.assertEquals("xuyj", giser.getName());
    }

    @Test
    @Transactional
    //@Transactional注解可以让数据自动回滚，这样测试的数据不会被加入到数据库中
    public void testSaveGiser() {
        Giser giser = new Giser();
        giser.setName("Junit");
        service.saveGiser(giser);
    }
}
