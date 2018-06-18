package com.springboot.studentmanagementsystem.dao;

import com.springboot.studentmanagementsystem.model.Student;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findAllByFirstName(String name);

    List<Student> findAll(Specification<Student> specification);
}
