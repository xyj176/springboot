package cn.xuyj.springboot.example.test;

import cn.xuyj.springboot.example.test.domain.Giser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/15 14:18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GiserControllerTest {
    //模拟一个MVC环境，向Controller发送请求然后得到响应
    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Autowired
    ObjectMapper objectMapper;

    @Before
    public void setupMockMVC() {
        //初始化MockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testFindByName() throws Exception {
        String name = "xuyj";
        //请求http://localhost:port/<context-path>/giser/{name}
        mockMvc.perform(MockMvcRequestBuilders.get("/giser/{name}", name)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Transactional
    public void testSaveGiser() throws Exception {
        Giser giser = new Giser();
        giser.setName("zhangsan");
        giser.setPasswd("X20241115.");
        String value = objectMapper.writeValueAsString(giser);
        mockMvc.perform(MockMvcRequestBuilders.post("/giser/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(value.getBytes()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

}
