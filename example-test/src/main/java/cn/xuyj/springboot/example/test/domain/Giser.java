package cn.xuyj.springboot.example.test.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author xuyj
 * @des 描述
 * @since 2024/11/15 11:08
 */
@Table(name = "giser")
@Data
public class Giser implements Serializable {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String passwd;

    @Column(name = "create_time")
    private Date createTime;
}
