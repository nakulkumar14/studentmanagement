package com.springboot.studentmanagementsystem.service.impl;

import com.springboot.studentmanagementsystem.dao.StudentRepository;
import com.springboot.studentmanagementsystem.model.Student;
import com.springboot.studentmanagementsystem.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service("studentService")
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student get(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentByName(String name) {
        log.info("[StudentServiceImpl][getStudentByName] Name : {}",name);
        try {
            return studentRepository.findAllByFirstName(name);
        }catch (Exception e){
            log.error("[StudentServiceImpl][getStudentByName] Exception occurred for Name : "+name,e);
        }
        return null;
    }

    @Override
    public Student addStudent(Student student) {
        student.setCreatedAt(new Date());
        student.setUpdatedAt(new Date());
        student.getParent().setCreatedAt(new Date());
        student.getParent().setUpdatedAt(new Date());
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }
}
