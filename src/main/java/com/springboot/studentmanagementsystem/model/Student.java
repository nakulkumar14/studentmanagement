package com.springboot.studentmanagementsystem.model;

import com.springboot.studentmanagementsystem.types.Gender;
import com.springboot.studentmanagementsystem.types.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public @Data class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dob;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "phone_no")
    private String phone;
    @Column(name = "status")
    private String status;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "leaving_date")
    private Date leavingDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Parent parent;
}
