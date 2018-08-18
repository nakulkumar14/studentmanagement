package com.springboot.studentmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "classroom")
public class Classroom implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "standard")
    private String standard;

    @Column(name = "section")
    private String section;

    @Column(name = "year")
    private Integer year;

    @ManyToMany(mappedBy = "classrooms")
    private Set<Student> students;
}
