package cn.xuyj.springboot.example.mapper;

import cn.xuyj.springboot.example.bean.Student;
import org.apache.ibatis.annotations.*;

/**
 * @author xuyj
 * @since 2024/7/17 15:15
 */
@Mapper
public interface StudentMapper {

    @Update("update student set name=#{name},sex=#{sex} where id=#{id}")
    int update(Student student);

    @Delete("delete from student where id=#{id}")
    int delete(String id);

    @Select("select * from student where id=#{id}")
    @Results(id = "student", value = {
            @Result(property = "id", column = "id", javaType = String.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "sex", column = "sex", javaType = String.class)
    })
    Student query(String id);
}
