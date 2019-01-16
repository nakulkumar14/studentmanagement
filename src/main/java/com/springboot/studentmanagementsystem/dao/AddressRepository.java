package com.springboot.studentmanagementsystem.dao;

import com.springboot.studentmanagementsystem.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer>{
}
