package com.springboot.studentmanagementsystem.dao;

import com.springboot.studentmanagementsystem.model.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Long>{
    List<Teacher> findByFirstName(String name);
}
