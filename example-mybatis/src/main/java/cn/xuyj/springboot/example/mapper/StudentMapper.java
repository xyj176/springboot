package cn.xuyj.springboot.example.mapper;

import cn.xuyj.springboot.example.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author xuyj
 * @since 2024/7/15 14:46
 */
@Mapper
@Component
public interface StudentMapper {
    @Insert("insert into student(id,name,sex) values(#{id},#{name},#{sex})")
    int add(Student student);

    @Update("update student set name=#{name},sex=#{sex} where id=#{id}")
    int update(Student student);

    @Delete("delete from student where id=#{id}")
    int deleteById(String id);

    @Select("select * from student where id=#{id}")
    @Results(id = "student", value = {
            @Result(property = "id", column = "id", javaType = String.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "sex", column = "sex", javaType = String.class),
    })
    Student queryById(String id);
}
