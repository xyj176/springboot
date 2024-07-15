package cn.xuyj.springboot.example.dao.impl;

import cn.xuyj.springboot.example.dao.StudentDao;
import cn.xuyj.springboot.example.entity.Student;
import cn.xuyj.springboot.example.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * @author xuyj
 * @since 2024/7/15 17:01
 */
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Student student) {
        String sql = "insert into student(id,name,sex) values(:id,:name,:sex)";
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
        int update = npjt.update(sql, new BeanPropertySqlParameterSource(student));
        return update;
    }

    @Override
    public int update(Student student) {
        String sql = "update student set name=?,sex=? where id=?";
        Object[] args = {student.getName(), student.getSex(), student.getId()};
        int[] argTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        int update = jdbcTemplate.update(sql, args, argTypes);
        return update;
    }

    @Override
    public int delete(String id) {
        String sql = "delete from student where id=?";
        Object[] args = {id};
        int[] argTypes = {Types.VARCHAR};
        int update = jdbcTemplate.update(sql, args, argTypes);
        return update;
    }

    @Override
    public Student queryById(String id) {
        String sql = "select * from student where id=?";
        Object[] args = {id};
        int[] argTypes = {Types.VARCHAR};
        List<Student> students = jdbcTemplate.query(sql, args, argTypes, new StudentMapper());
        if (students != null && students.size() > 0) {
            return students.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> queryStudents() {
        String sql = "select * from student";
        List<Map<String, Object>> query = jdbcTemplate.queryForList(sql);
        return query;
    }
}
