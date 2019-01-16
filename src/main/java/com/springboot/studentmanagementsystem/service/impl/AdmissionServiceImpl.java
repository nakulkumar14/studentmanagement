package com.springboot.studentmanagementsystem.service.impl;

import com.springboot.studentmanagementsystem.dao.AddressRepository;
import com.springboot.studentmanagementsystem.dao.TeacherRepository;
import com.springboot.studentmanagementsystem.dto.AdmitStudentRequest;
import com.springboot.studentmanagementsystem.dto.AdmitTeacherRequest;
import com.springboot.studentmanagementsystem.model.Address;
import com.springboot.studentmanagementsystem.model.Teacher;
import com.springboot.studentmanagementsystem.service.IAdmissionService;
import com.springboot.studentmanagementsystem.types.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class AdmissionServiceImpl implements IAdmissionService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void admitNewTeacher(AdmitTeacherRequest admitTeacherRequest) {
        if (admitTeacherRequest !=null){
            List<Teacher> teachers = teacherRepository.findByFirstNameAndLastName(admitTeacherRequest.getTeacher().getFirstName(), admitTeacherRequest.getTeacher().getLastName());
            if (CollectionUtils.isEmpty(teachers)){
                Address address = admitTeacherRequest.getAddress();
                Address savedAddress = addressRepository.save(address);

                Teacher teacher = admitTeacherRequest.getTeacher();
                teacher.setAddress(savedAddress);
                teacher.setStatus(Status.ACTIVE);
                teacher.setCreatedAt(new Date());
                teacher.setUpdatedAt(new Date());

                teacherRepository.save(teacher);
            }
        }
    }

    @Override
    public void admitNewStudent(AdmitStudentRequest request) {
        if (request!=null){

        }
    }
}
