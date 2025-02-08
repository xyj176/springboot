package cn.xuyj.springboot.example.mongodb.service;

import java.io.InputStream;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/8 16:43
 */
public interface MongodbService {
    public Boolean upload(String file, String bucket);

    public Boolean upload(InputStream ins, String name, String bucket);

    public String downloadById(String id, String bucket);

    public String downloadByName(String fileName, String bucket);
}
