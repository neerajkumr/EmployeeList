package com.springboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.dao.EmployeeDAO;
import com.springboot.domain.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDAO dao;

	@GetMapping(path = "/employee/list")
	public List<Employee> list() {
		System.out.println("The list contains...");
		return dao.list();

	}

	@PostMapping(path = "/employee/insert")
	public List<Employee> create(@RequestBody Employee emp) {
		System.out.println("---Data was Inserted---");
		return dao.save(emp);
		
	}

	@GetMapping(path = "/employee/employeebyID/{id}")
	public Employee getById(@PathVariable int id) {
		return dao.getById(id);

	}

	@DeleteMapping(path = "/employee/delbyID/{id}")
	public List<Employee> deleteById(@PathVariable int id) {
		return dao.deleteById(id);

	}

	@PutMapping(path="/employee/update")
	public List<Employee> updateDetails(){
		System.out.println("The details was updated");
		return dao.updateById();
		
	}
}
