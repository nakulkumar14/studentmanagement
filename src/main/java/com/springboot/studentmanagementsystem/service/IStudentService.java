package com.springboot.studentmanagementsystem.service;

import com.springboot.studentmanagementsystem.dto.SearchStudentRequest;
import com.springboot.studentmanagementsystem.model.Student;

import java.util.List;

public interface IStudentService {
    Student get(Long id);
    void delete(Long id);
    void save(Student student);
    List<Student> getStudentByName(String name);

    Student addStudent(Student student);

    List<Student> getAllStudents();

    List<Student> getStudentRecords(SearchStudentRequest request);
}
