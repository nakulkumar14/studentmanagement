package com.springboot.studentmanagementsystem.controller;

import com.springboot.studentmanagementsystem.dto.AdmitStudentRequest;
import com.springboot.studentmanagementsystem.dto.AdmitTeacherRequest;
import com.springboot.studentmanagementsystem.model.Teacher;
import com.springboot.studentmanagementsystem.service.IAdmissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AdmissionController {

    @Autowired
    private IAdmissionService admissionService;

    @PostMapping("/admitNewTeacher")
    public void admitNewTeacher(@RequestBody AdmitTeacherRequest request){
        admissionService.admitNewTeacher(request);
    }

    @PostMapping("/admitNewStudent")
    public void admitNewStudent(@RequestBody AdmitStudentRequest request){
        admissionService.admitNewStudent(request);
    }

}
