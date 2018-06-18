package com.springboot.studentmanagementsystem.dto;

import com.springboot.studentmanagementsystem.types.Gender;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SearchStudentRequest implements Serializable{

    private static final long serialVersionUID = -2059025719152307188L;

    private String firstName;
    private String lastName;
    private Date dob;
    private String mobile;
    private String phone;
    private Gender gender;
    private Date createdAt;
}
