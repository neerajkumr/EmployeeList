package com.springboot.dao;

import java.util.*;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.springboot.domain.Employee;
@EnableJpaRepositories
@ComponentScan("com.springboot")
@Repository
public class EmployeeDAO {

	static ArrayList<Employee> employeeList = new ArrayList<Employee>();

	static {
		employeeList.add(new Employee(1L, "Elizabeth", "elizabeth@gmail.com", 4.2, "7845128956"));
		employeeList.add(new Employee(2L, "Michael", "michael@gmail.com", 2.0, "7441855296"));
		employeeList.add(new Employee(3L, "Charlotte", "charlotte@gmail.com", 3.1, "9663855274"));
		employeeList.add(new Employee(4L, "Lucas", "lucas@gmail.com", 1.9, "8956231245"));
	}

	public List<Employee> list() {
		return employeeList;
	}

	public ArrayList<Employee> save(Employee employee) {
		employeeList.add(employee);
		return employeeList;
	}

	public Employee getById(int id) {
		if(employeeList.get(id)!=null) 
		System.out.println("Employee was Fetched using ID");
		return employeeList.get(id - 1);
		
	}

	public List<Employee> deleteById(int id) {

		employeeList.remove(id - 1);
		return employeeList;
	}
	
	public ArrayList<Employee> updateById() {
		for(Employee e:employeeList) {
		if(e.getId()==1) {
			e.setName("linlin charlotte");
			e.setEmail("linlinchar227@gmail.com");
			e.setExperience(12.4);
			e.setMobilenumber("38137389781");
		}
		}
		return employeeList;
		
	}
}
