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

/**
 * @Author: xuyj
 * @Date: 2025/5/17 12:34
 * @Email: 1768335576@qq.com
 * @Desc：类描述
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //验证用户名
        CustomUser customUser = findByUserName(username);
        if (customUser == null) {
            throw new RuntimeException("用户【"+username+"】不存在");
        }
        //这里返回正确的密码，后续会和登录请求中的密码进行匹配
        User user = new User(username, customUser.getPassword(),
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("user"));
        return user;
    }

    //判断用户名是否存在
    //todo 从数据库中去读取
    private CustomUser findByUserName(String username){
        if (!username.equals("xuyj")) {
            return null;
        }
        CustomUser user = new CustomUser();
        user.setUsername("xuyj");
        user.setPassword(passwordEncoder.encode("123456"));
        return user;
    }
}
