package cn.xuyj.springboot.example.mapper;

import cn.xuyj.springboot.example.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xuyj
 * @since 2024/7/15 17:04
 */
public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getString("id"));
        student.setName(rs.getString("name"));
        student.setSex(rs.getString("sex"));
        return student;
    }
}
