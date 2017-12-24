package com.springboot.studentmanagementsystem.service.impl;

import com.springboot.studentmanagementsystem.dao.ParentRepository;
import com.springboot.studentmanagementsystem.model.Parent;
import com.springboot.studentmanagementsystem.service.IParentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("parentService")
public class ParentServiceImpl implements IParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Override
    public Parent getParentDetailsByStudentId(Long id) {
        return parentRepository.findByStudentId(id);
    }

    @Override
    public void save(Parent parent) {
        parentRepository.save(parent);
    }
}
