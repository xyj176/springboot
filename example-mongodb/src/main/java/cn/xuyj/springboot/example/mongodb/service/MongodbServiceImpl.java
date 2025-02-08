package cn.xuyj.springboot.example.mongodb.service;

import cn.hutool.core.util.StrUtil;
import cn.xuyj.springboot.example.mongodb.config.ConfigBean;
import cn.xuyj.springboot.example.mongodb.util.PathUtil;
import com.mongodb.client.gridfs.model.GridFSFile;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/8 16:49
 */
@Service
@Slf4j
public class MongodbServiceImpl implements MongodbService {
    @Autowired
    private ConfigBean config;

    @Autowired
    private MongoDbFactory mongoDbFactory;

    @Autowired
    private MongoConverter mongoConverter;

    /**
     * mongodb默认的文件存储桶的名称
     */
    private static final String DEFAULT_BUCKET = "fs";

    /**
     * GridFsTemplate的字典：一个文件存储桶对应一个GridFsTemplate
     */
    private Map<String, GridFsTemplate> GRIDFSTEMPLATE_MAP = new HashMap<>();

    @PostConstruct
    public void init() {
        String buckets = config.getBuckets();
        List<String> bucketList = Arrays.stream(buckets.split(",")).collect(Collectors.toList());
        for (String bucket : bucketList) {
            if (!GRIDFSTEMPLATE_MAP.containsKey(bucket)) {
                GridFsTemplate gridFsTemplate = new GridFsTemplate(mongoDbFactory, mongoConverter, bucket);
                GRIDFSTEMPLATE_MAP.put(bucket, gridFsTemplate);
            }
        }
    }

    @Override
    public Boolean upload(String file, String bucket) {
        File f = new File(file);
        InputStream fis = null;
        try {
            fis = new FileInputStream(f);
            return upload(fis, f.getName(), bucket);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    log.error("关闭文件流失败：" + e.getMessage());
                }
            }

        }
    }

    @Override
    public Boolean upload(InputStream ins, String name, String bucket) {
        GridFsTemplate gridFsTemplate = getGridFsTemplate(bucket);
        ObjectId objectId = gridFsTemplate.store(ins, name);
        log.info("文件【" + name + "】存储后的id：" + objectId);
        return true;
    }

    @Override
    public String downloadById(String id, String bucket) {
        GridFsTemplate gridFsTemplate = getGridFsTemplate(bucket);
        Query query = Query.query(GridFsCriteria.where("_id").is(id));
        GridFSFile gridFSFile = gridFsTemplate.findOne(query);
        if (gridFSFile == null) {
            log.error("根据id【" + id + "】从mongodb中查询到的文件为空或不存在");
            return null;
        }
        return saveGridFsFileToLocal(gridFsTemplate, gridFSFile);
    }

    @Override
    public String downloadByName(String fileName, String bucket) {
        GridFsTemplate gridFsTemplate = getGridFsTemplate(bucket);
        Query query = Query.query(GridFsCriteria.whereFilename().is(fileName));
        GridFSFile gridFSFile = gridFsTemplate.findOne(query);
        if (gridFSFile == null) {
            log.error("根据文件名【" + fileName + "】从mongodb中查询到的文件为空或不存在");
            return null;
        }
        return saveGridFsFileToLocal(gridFsTemplate, gridFSFile);
    }

    /**
     * 根据bucket名称获取相应的GridFsTemplate
     *
     * @param bucket
     * @return
     */
    private GridFsTemplate getGridFsTemplate(String bucket) {
        if (StrUtil.isEmpty(bucket))
            bucket = DEFAULT_BUCKET;
        if (GRIDFSTEMPLATE_MAP.containsKey(bucket))
            return GRIDFSTEMPLATE_MAP.get(bucket);
        GridFsTemplate gridFsTemplate = new GridFsTemplate(mongoDbFactory, mongoConverter, bucket);
        GRIDFSTEMPLATE_MAP.put(bucket, gridFsTemplate);
        return gridFsTemplate;
    }

    private String saveGridFsFileToLocal(GridFsTemplate gridFsTemplate, GridFSFile gridFSFile) {
        GridFsResource resource = gridFsTemplate.getResource(gridFSFile);
        String filename = resource.getFilename();
        String localFilePath = PathUtil.combine(PathUtil.createTmpDir(), filename);
        InputStream ins = null;
        FileOutputStream fops = null;
        try {
            ins = resource.getInputStream();
            File localFile = new File(localFilePath);
            fops = new FileOutputStream(localFile);
            IOUtils.copy(ins, fops);
            log.info("保存到本地的文件路径：" + localFilePath);
            return localFilePath;
        } catch (Exception e) {
            log.error("GridFSFile保存到本地失败：" + e.getMessage());
            return null;
        } finally {
            if (ins != null) {
                try {
                    ins.close();
                } catch (Exception e) {
                    log.error("关闭文件流失败：" + e.getMessage());
                }
            }
            if (fops != null) {
                try {
                    fops.close();
                } catch (Exception e) {
                    log.error("关闭文件流失败：" + e.getMessage());
                }
            }
        }
    }
}
