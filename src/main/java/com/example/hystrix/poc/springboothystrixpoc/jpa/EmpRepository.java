package com.example.hystrix.poc.springboothystrixpoc.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hystrix.poc.springboothystrixpoc.model.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {

}
