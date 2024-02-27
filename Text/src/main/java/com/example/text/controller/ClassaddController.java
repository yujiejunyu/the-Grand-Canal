package com.example.text.controller;

import com.example.text.pojo.Classroom;
import com.example.text.pojo.Result;
import com.example.text.service.Interface.ClassaddService;
import com.example.text.service.Interface.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ClassaddController {
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private ClassaddService classaddService;

    //添加课堂信息
    @PostMapping("/classadd")
    public Result classadd(String title, String author, String brief, String title_photo, String datetype, String video, String video_source) {

        //判断标题是否存在
        Classroom c = classroomService.findTitle(title);
        //标题存在
        if (c != null) {
            return Result.error("文章已存在");
        } else {
            //标题不存在
            //将类型转化成id
            int date_type = 0;
            if ("地质灾害".equals(datetype)) {
                date_type = 1;
            } else if ("气象灾害".equals(datetype)) {
                date_type = 2;
            } else if ("有毒生物".equals(datetype)) {
                date_type = 3;
            } else if (datetype == "有毒生物") {
                date_type = 4;
            } else if ("火灾火情".equals(datetype)) {
                date_type = 5;
            }
            classaddService.add(title, author, brief, title_photo, date_type, video, video_source);
        }

        return Result.success("添加成功");
    }

    //修改课堂信息
    @PostMapping("update")
    public Result classupdate(int id,String title, String author, String brief, String title_photo, String datetype, String video, String video_source) {
        //判断id是否存在
        Classroom c = classaddService.findId(id);
        //标题存在
        if (c == null) {
            return Result.error("文章不存在");
        } else {
            //将类型转化成id
            int date_type = 0;
            if ("地质灾害".equals(datetype)) {
                date_type = 1;
                System.out.println(date_type + datetype);
            } else if ("气象灾害".equals(datetype)) {
                date_type = 2;
            } else if ("有毒生物".equals(datetype)) {
                date_type = 3;
            } else if (datetype == "有毒生物") {
                date_type = 4;
            } else if ("火灾火情".equals(datetype)) {
                date_type = 5;
            }
            classaddService.update(title, author, brief, title_photo, date_type, video, video_source);
        }
        return Result.success("修改成功");
    }
}
