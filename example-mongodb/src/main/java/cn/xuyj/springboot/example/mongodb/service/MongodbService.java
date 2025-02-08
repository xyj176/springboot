package cn.xuyj.springboot.example.mongodb.service;

import java.io.InputStream;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/8 16:43
 */
public interface MongodbService {
    /**
     * 文件上传
     * @param file：本地文件路径
     * @param bucket：存储桶
     * @return
     */
    public Boolean upload(String file, String bucket);

    /**
     * 文件上传
     * @param ins：文件流
     * @param name：文件名称
     * @param bucket：存储桶
     * @return
     */
    public Boolean upload(InputStream ins, String name, String bucket);

    /**
     * 根据文件id下载
     * @param id
     * @param bucket
     * @return
     */
    public String downloadById(String id, String bucket);

    /**
     * 根据文件名称下载
     * @param fileName
     * @param bucket
     * @return
     */
    public String downloadByName(String fileName, String bucket);
}
