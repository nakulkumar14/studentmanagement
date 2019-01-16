package com.springboot.studentmanagementsystem.service;

import com.springboot.studentmanagementsystem.model.Teacher;

import java.util.List;

public interface ITeacherService {

    Teacher get(Long id);
    void delete(Long id);
    Teacher save(Teacher teacher);
    List<Teacher> getTeacherByName(String name);

    List<Teacher> getAllTeachers();

}
