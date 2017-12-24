package com.springboot.studentmanagementsystem.service;

import com.springboot.studentmanagementsystem.model.Parent;

public interface IParentService {
    Parent getParentDetailsByStudentId(Long id);
    void save(Parent parent);
}
