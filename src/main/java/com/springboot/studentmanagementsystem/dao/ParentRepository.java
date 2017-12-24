package com.springboot.studentmanagementsystem.dao;

import com.springboot.studentmanagementsystem.model.Parent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ParentRepository extends CrudRepository<Parent,Long>{

    @Query(value = "select * from parent p join student s on s.parent_id = p.id and s.id = ?1",nativeQuery = true)
    Parent findByStudentId(Long id);
}
