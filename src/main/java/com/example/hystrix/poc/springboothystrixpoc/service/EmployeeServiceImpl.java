package com.example.hystrix.poc.springboothystrixpoc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hystrix.poc.springboothystrixpoc.jpa.EmpRepository;
import com.example.hystrix.poc.springboothystrixpoc.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmpRepository repository;

	public void setEmployeeRepository(EmpRepository empRepository) {
		this.repository = empRepository;
	}

	public List<Employee> retrieveEmployees() {
		List<Employee> employee = repository.findAll();
		return employee;
	}

	public Employee getEmployee(Long employeeId) {
		Optional<Employee> optEmp = repository.findById(employeeId);
		return optEmp.get();
	}

	public void saveEmployee(Employee employee) {
		repository.save(employee);

	}

	public void deleteEmployee(Long employeeId) {
		repository.deleteById(employeeId);

	}

	public void updateEmployee(Employee employee) {
		repository.save(employee);

	}

}
