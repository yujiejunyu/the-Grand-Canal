package com.example.text.service.Interface;

import com.example.text.pojo.Classroom;

public interface ClassaddService {
    //添加课堂信息
    void add(String title, String author, String brief, String titlePhoto, int dateType, String video, String videoSource);
    //修改课堂信息
    void update(String title, String author, String brief, String titlePhoto, int dateType, String video, String videoSource);
    //查询id
    Classroom findId(int id);
}
