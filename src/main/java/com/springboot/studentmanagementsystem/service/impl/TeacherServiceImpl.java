package com.springboot.studentmanagementsystem.service.impl;

import com.springboot.studentmanagementsystem.dao.TeacherRepository;
import com.springboot.studentmanagementsystem.model.Teacher;
import com.springboot.studentmanagementsystem.service.ITeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("teacherService")
public class TeacherServiceImpl implements ITeacherService{

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher get(Long id) {
        return teacherRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.delete(id);
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getTeacherByName(String name) {
        return teacherRepository.findByName(name);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return (List<Teacher>) teacherRepository.findAll();
    }
}
