package com.springboot.studentmanagementsystem.dto;

import com.springboot.studentmanagementsystem.model.Address;
import com.springboot.studentmanagementsystem.model.Salary;
import com.springboot.studentmanagementsystem.model.Teacher;
import lombok.Data;

import java.io.Serializable;

@Data
public class AdmitTeacherRequest implements Serializable{
    private Teacher teacher;
    private Address address;
}
