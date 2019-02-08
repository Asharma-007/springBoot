package com.example.hystrix.poc.springboothystrixpoc.service;

import java.util.List;

import com.example.hystrix.poc.springboothystrixpoc.model.Employee;


public interface EmployeeService {
	public List<Employee> retrieveEmployees();

	public Employee getEmployee(Long employeeId);

	public void saveEmployee(Employee employee);

	public void deleteEmployee(Long employeeId);

	public void updateEmployee(Employee employee);
}
