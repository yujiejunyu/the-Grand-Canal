package org.example.controller;

import org.example.pojo.Classroom;
import org.example.pojo.Result;
import org.example.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;
    @GetMapping("/detail")
    public Result<Classroom> detail(Integer date_type){
       Classroom c= classroomService.findBytype(date_type);
       return Result.success(c);
    }
}
