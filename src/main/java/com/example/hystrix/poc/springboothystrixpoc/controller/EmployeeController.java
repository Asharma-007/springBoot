package com.example.hystrix.poc.springboothystrixpoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hystrix.poc.springboothystrixpoc.model.Employee;
import com.example.hystrix.poc.springboothystrixpoc.service.EmployeeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/rest")
public class EmployeeController {

	@Autowired(required = true)
	EmployeeService service;

	public void setEmployeeService(EmployeeService service) {
		this.service = service;
	}

	@HystrixCommand(fallbackMethod = "fallbackMethod", groupKey = "Hello", threadPoolKey = "HelloHystrix")
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		List<Employee> employees = service.retrieveEmployees();
		return employees;
	}

	@HystrixCommand(fallbackMethod = "fallbackMethod", groupKey = "Hello")

	@GetMapping("/employees/{employeeid}")
	public Employee getEmployee(@PathVariable(name = "employeeid") Long employeeId) {
		return service.getEmployee(employeeId);

	}

	@PostMapping("/create/employees")
	public void saveEmployee(Employee employee) {
		service.saveEmployee(employee);
		System.out.println("Employee Saved Successfully");
	}

	@DeleteMapping("/delete/employees/{employeeId}")
	public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		service.deleteEmployee(employeeId);
		System.out.println("Employee deleted successfully!!!!");
	}

	@PutMapping("/employees/{employeeId}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable(name = "employeeId") Long employeeId) {
		Employee emp = service.getEmployee(employeeId);
		if (emp != null) {
			service.updateEmployee(employee);
		} else
			throw new RuntimeException("Failed to save 	Because employeed doesn't exist else return to Fallback");
	}

	public Employee fallbackMethod(Long id) {

		Employee employee = new Employee();
		employee.setId(id);
		employee.setName("There is no Employee exist hence you are seeing this Fallback");
		employee.setPassportNumber("I am From Netflix");

		return employee;

	}
}
