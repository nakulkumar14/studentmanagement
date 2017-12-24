package com.springboot.studentmanagementsystem.model;

import com.springboot.studentmanagementsystem.types.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "teacher")
public @Data class Teacher {
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
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Temporal(TemporalType.DATE)
    @Column(name = "leaving_date")
    private Date leavingDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;
}
