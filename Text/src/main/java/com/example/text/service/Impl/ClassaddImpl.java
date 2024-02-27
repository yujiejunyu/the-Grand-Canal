package com.example.text.service.Impl;

import com.example.text.mapper.ClassaddMapper;
import com.example.text.pojo.Classroom;
import com.example.text.service.Interface.ClassaddService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassaddImpl implements ClassaddService {
    @Autowired
    private ClassaddMapper classaddMapper;
    //添加课堂信息
    @Override
    public void add(String title, String author, String brief, String title_photo, int date_type, String video, String video_source) {
        classaddMapper.add(title,author,brief,title_photo,date_type,video,video_source);
    }
    //修改课堂信息
    @Override
    public void update(String title, String author, String brief, String title_photo, int date_type, String video, String video_source) {
        classaddMapper.update(title,author,brief,title_photo,date_type,video,video_source);
    }

    @Override
    public Classroom findId(int id) {
        Classroom c=classaddMapper.findId(id);
        return c;
    }


}
