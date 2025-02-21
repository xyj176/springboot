package cn.xuyj.springboot.example.kafka.domain;

import cn.hutool.json.JSONUtil;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xuyj
 * @des 描述
 * @since 2025/2/21 9:42
 */
@Data
public class Message implements Serializable {
    private static final long serialVersionUID = -3152099505847187440L;

    private Integer id;

    private String info;

    @Override
    public String toString(){
        return JSONUtil.toJsonStr(this);
    }
}
