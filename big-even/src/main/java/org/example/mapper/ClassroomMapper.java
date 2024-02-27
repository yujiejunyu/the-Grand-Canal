package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Classroom;
import org.springframework.web.bind.annotation.GetMapping;

@Mapper
public interface ClassroomMapper {

    //根据类型查询
    @Select("select *from em_class where date_type=#{type}")
    Classroom findBytype(Integer dateType);
}
