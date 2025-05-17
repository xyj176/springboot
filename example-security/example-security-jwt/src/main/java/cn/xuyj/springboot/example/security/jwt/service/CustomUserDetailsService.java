package cn.xuyj.springboot.example.security.jwt.service;

import cn.xuyj.springboot.example.security.jwt.domain.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xuyj
 * @Date: 2025/5/17 12:34
 * @Email: 1768335576@qq.com
 * @Desc：类描述
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    //默认用户
    private static Map<String,String> users = new HashMap<>();
    static {
        users.put("xuyj", "123456");
        users.put("admin", "123456");
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //验证用户名
        CustomUser customUser = findByUserName(username);
        if (customUser == null) {
            throw new RuntimeException("用户【"+username+"】不存在");
        }
        String authority = "user";
        if (username.equals("admin"))
            authority = "admin";
        //这里返回正确的密码，后续会和登录请求中的密码进行匹配
        User user = new User(username, customUser.getPassword(),
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList(authority));
        return user;
    }

    //判断用户名是否存在
    //todo 从数据库中去读取
    private CustomUser findByUserName(String username){
        //如果users中包含该用户名，则返回该用户
        if (users.containsKey(username)) {
            CustomUser user = new CustomUser();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(users.get(username)));
            return user;
        }
        return null;
    }
}
