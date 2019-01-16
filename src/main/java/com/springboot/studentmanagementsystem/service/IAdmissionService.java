package com.springboot.studentmanagementsystem.service;

import com.springboot.studentmanagementsystem.dto.AdmitStudentRequest;
import com.springboot.studentmanagementsystem.dto.AdmitTeacherRequest;

public interface IAdmissionService {

    void admitNewTeacher(AdmitTeacherRequest admitTeacherRequest);

    void admitNewStudent(AdmitStudentRequest request);
}
