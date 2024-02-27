package org.example.service.impl;

import org.example.mapper.ClassroomMapper;
import org.example.pojo.Classroom;
import org.example.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomMapper classroomMapper;
    @Override
    public Classroom findBytype(Integer dateType) {
        Classroom c=classroomMapper.findBytype(dateType);
        return c;
    }
}
