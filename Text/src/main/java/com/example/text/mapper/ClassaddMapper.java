package com.example.text.mapper;

import com.example.text.pojo.Classroom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PostMapping;

@Mapper
public interface ClassaddMapper {
    //添加课堂信息
    @Insert("insert into em_class (title, author, brief, title_photo, date_type, video, video_source) value(#{title}, #{author}, #{brief}, #{title_photo}, #{date_type}, #{video}, #{video_source})")
    void add(String title, String author, String brief, String title_photo, int date_type, String video, String video_source);
    //修改课堂信息
    @Update("update em_class set title=#{title},author=#{author},brief=#{brief},title_phone=#{title_phone},video=#{video},video_source={video_source}")
    void update(String title, String author, String brief, String titlePhoto, int dateType, String video, String videoSource);
    @Select("select * from em_class where id=#{id}")
    Classroom findId(int id);
}
