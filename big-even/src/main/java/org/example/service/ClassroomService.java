package org.example.service;

import org.example.pojo.Classroom;

public interface ClassroomService {
    //根据类型查询信息
    Classroom findBytype(Integer dateType);
}
