package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {

	public EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	// Build Create Employee REst API
	@PostMapping
	public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Object>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "{employee_id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employee_id){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employee_id), HttpStatus.OK);
	}
	
	
	// Build update Employee Rest Api
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
	}
	
	// Delete Employee Rest API
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		return new ResponseEntity<String>("Employee id "+ id + "deleed", HttpStatus.OK);
	}
}
