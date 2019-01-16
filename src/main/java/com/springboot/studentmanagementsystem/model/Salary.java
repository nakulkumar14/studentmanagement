package com.springboot.studentmanagementsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "salary")
@Entity
@Data
public class Salary implements Serializable {

    private static final long serialVersionUID = -7106071974299799519L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "from_date")
    private Date fromDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "to_date")
    private Date toDate;
    @Column(name = "salary_amount")
    private Double salaryAmount;

}
