package com.springboot.studentmanagementsystem.dao.specification;

import com.springboot.studentmanagementsystem.model.Student;
import com.springboot.studentmanagementsystem.model.Student_;
import com.springboot.studentmanagementsystem.types.Gender;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class StudentSpecification {

    public static Specification<Student> initialize(){
        return null;
    }

    public static Specification<Student> whereFirstName(String firstName){
        return ((root, query, cb) -> cb.equal(root.get(Student_.firstName), firstName));
    }

    public static Specification<Student> whereLastName(String lastName){
        return ((root, query, cb) -> cb.equal(root.get(Student_.lastName), lastName));
    }

    public static Specification<Student> whereMobile(String mobile){
        return ((root, query, cb) -> cb.equal(root.get(Student_.mobile), mobile));
    }

    public static Specification<Student> wherePhone(String phone){
        return ((root, query, cb) -> cb.equal(root.get(Student_.phone), phone));
    }

    public static Specification<Student> whereDOB(Date dob){
        return ((root, query, cb) -> cb.equal(root.get(Student_.dob), dob));
    }

    public static Specification<Student> whereGender(Gender gender){
        return ((root, query, cb) -> cb.equal(root.get(Student_.gender), gender));
    }

}
