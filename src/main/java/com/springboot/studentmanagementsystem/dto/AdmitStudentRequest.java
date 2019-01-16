package com.springboot.studentmanagementsystem.dto;

import com.springboot.studentmanagementsystem.model.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class AdmitStudentRequest implements Serializable {
    private Student student;
    private Address address;
    private Parent parent;
    private Classroom classroom;
}