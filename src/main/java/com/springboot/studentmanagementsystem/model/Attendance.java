package com.springboot.studentmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "attendance")
@Entity
public class Attendance implements Serializable{

    private static final long serialVersionUID = -3359471765630470176L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "attended")
    private boolean attended;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date created_at;
}
