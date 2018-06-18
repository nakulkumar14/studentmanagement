package com.springboot.studentmanagementsystem.service.impl;

import com.springboot.studentmanagementsystem.dao.StudentRepository;
import com.springboot.studentmanagementsystem.dao.specification.StudentSpecification;
import com.springboot.studentmanagementsystem.dto.SearchStudentRequest;
import com.springboot.studentmanagementsystem.model.Student;
import com.springboot.studentmanagementsystem.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    @Override
    public List<Student> getStudentRecords(SearchStudentRequest request) {
        Specification<Student> specification = createSpecificationFromRequest(request);
        if (specification!=null){
            return studentRepository.findAll(specification);
        }
        return null;
    }

    private Specification<Student> createSpecificationFromRequest(SearchStudentRequest request){
        Specification<Student> specification = StudentSpecification.initialize();
        if (StringUtils.isNotBlank(request.getFirstName())){
            specification = Specifications.where(specification).and(StudentSpecification.whereFirstName(request.getFirstName()));
        }

        if (StringUtils.isNotBlank(request.getLastName())){
            specification = Specifications.where(specification).and(StudentSpecification.whereLastName(request.getLastName()));
        }

        if (StringUtils.isNotBlank(request.getMobile())){
            specification = Specifications.where(specification).and(StudentSpecification.whereMobile(request.getMobile()));
        }

        if (StringUtils.isNotBlank(request.getPhone())){
            specification = Specifications.where(specification).and(StudentSpecification.wherePhone(request.getPhone()));
        }

        if (request.getGender()!=null){
            specification = Specifications.where(specification).and(StudentSpecification.whereGender(request.getGender()));
        }

        if (request.getDob()!=null){
            specification = Specifications.where(specification).and(StudentSpecification.whereDOB(request.getDob()));
        }

        return specification;
    }
}
