package com.springboot.studentmanagementsystem.controller;

import com.springboot.studentmanagementsystem.dto.SearchStudentRequest;
import com.springboot.studentmanagementsystem.model.Parent;
import com.springboot.studentmanagementsystem.model.Student;
import com.springboot.studentmanagementsystem.service.IParentService;
import com.springboot.studentmanagementsystem.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IParentService parentService;

    @RequestMapping(value="/")
    public String welcome() {
        return "welcome to student management system";
    }

    @RequestMapping(value = "/getStudentById/{id}",method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") Long id){
        return studentService.get(id);
    }

    @RequestMapping(value = "/getStudentByName/{name}",method = RequestMethod.GET)
    public List<Student> getStudentByName(@PathVariable("name") String name){
        return studentService.getStudentByName(name);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student){
        log.info("[AdminController][addStudent] Request for : {}",student);
        return studentService.addStudent(student);
    }

    @RequestMapping(value = "/removeStudent/{id}", method = RequestMethod.GET)
    public void removeStudent(@PathVariable("id") Long id){
        log.info("[AdminController][removeStudent] Id : {}",id);
        studentService.delete(id);
    }

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/getParentDetailsByStudentId/{id}", method = RequestMethod.GET)
    public Parent getParentDetailsByStudentId(@PathVariable("id") Long id){
        log.info("[AdminController][getParentDetailsByStudentId] id : {}",id);
        return parentService.getParentDetailsByStudentId(id);
    }

    @RequestMapping(value = "/updateParentDetails", method = RequestMethod.POST)
    public void updateParentDetails(@RequestBody Parent parent){
        log.info("[AdminController][updateParentDetails] Parent : {}",parent);
        parentService.save(parent);
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public List<Student> searchStudent(@RequestBody SearchStudentRequest request){
        log.info("request : {}" , request);
        List<Student> studentList = studentService.getStudentRecords(request);
        log.info("[searchStudent] students : {}", studentList);
        return studentList;
    }
}
