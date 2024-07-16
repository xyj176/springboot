package cn.xuyj.springboot.example.controller;

import cn.xuyj.springboot.example.bean.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuyj
 * @since 2024/7/16 15:37
 */
@Controller
public class IndexController {

    @RequestMapping("/account")
    public String index(Model m) {
        List<Account> list = new ArrayList<>();
        list.add(new Account("Kangkang", "康康", "e10adc3949ba59abbe56e", "超级管理员", "17777777777"));
        list.add(new Account("Mike", "麦克", "e10adc3949ba59abbe56e", "管理员", "18888888888"));
        list.add(new Account("Jane", "简", "e10adc3949ba59abbe56e", "运维人员", "16666666666"));
        list.add(new Account("Maria", "玛丽亚", "e10adc3949ba59abbe56e", "清算人员", "15555555555"));
        m.addAttribute("accountList", list);
        return "account";
    }
}
