package com.springboot.studentmanagementsystem.controller;

import com.springboot.studentmanagementsystem.model.Teacher;
import com.springboot.studentmanagementsystem.service.ITeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @GetMapping("/getAllTeachers")
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachers();
    }

    @GetMapping("/getTeacherById/{id}")
    public Teacher getTeacherById(@PathVariable("id") Long id){
        return teacherService.get(id);
    }

    @PostMapping("/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherService.save(teacher);
    }

    @GetMapping("/removeTeacher/{id}")
    public void removeTeacher(@PathVariable("id") Long id){
        teacherService.delete(id);
    }
}
