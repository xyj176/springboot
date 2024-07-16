package cn.xuyj.springboot.example.dao.impl;

import cn.xuyj.springboot.example.dao.SysLogDao;
import cn.xuyj.springboot.example.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author xuyj
 * @since 2024/7/16 10:49
 */
@Repository
public class SysLogDaoImpl implements SysLogDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(SysLog sysLog) {
        StringBuffer sql = new StringBuffer("insert into sys_log ");
        sql.append("(id,username,operation,time,method,params,ip,create_time)");
        sql.append("values(nextval('seq_sys_log'),:username,:operation,:time,:method,:params,:ip,:createTime)");

        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        npjt.update(sql.toString(), new BeanPropertySqlParameterSource(sysLog));
    }
}
