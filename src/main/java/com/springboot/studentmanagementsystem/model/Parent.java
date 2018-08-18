package com.springboot.studentmanagementsystem.model;

import com.springboot.studentmanagementsystem.types.Gender;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "parent")
public @Data class Parent implements Serializable{

    private static final long serialVersionUID = -6349669798181599740L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstname", nullable = false)
    private String firstName;
    @Column(name = "lastname", nullable = false)
    private String lastName;
    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dob;
//    @Column(name = "mobile")
//    private String mobile;
//    @Column(name = "phone_no")
//    private String phone;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender = Gender.MALE;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "spouse_firstname", nullable = false)
    private String spouseFirstname;
    @Column(name = "spouse_lastname", nullable = false)
    private String spouseLastname;
//    @Column(name = "spouse_mobile")
//    private String spouseMobile;
    @Column(name = "spouse_dob")
    private Date spouseDob;
}
