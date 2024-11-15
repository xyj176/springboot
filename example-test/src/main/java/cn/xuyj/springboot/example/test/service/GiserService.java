package cn.xuyj.springboot.example.test.service;

import cn.xuyj.springboot.example.test.domain.Giser;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/15 11:15
 */
public interface GiserService extends IService<Giser> {
    Giser findByName(String name);

    void saveGiser(Giser giser);
}
