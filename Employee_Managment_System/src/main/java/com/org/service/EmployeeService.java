package com.org.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.entity.Employee;
import com.org.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;

	
	public Employee addEmployee(Employee emp) {
		
		Employee addedemp = empRepository.save(emp);
		
		return addedemp;
		
	}


	public Employee updateEmployee(int i, Employee emp) {

		Optional<Employee> employee =  empRepository.findById(i);
		Employee oldemp = employee.get();
		oldemp.setName(emp.getName());
		oldemp.setAddress(emp.getAddress());
		oldemp.setPhone(emp.getPhone());
		oldemp.setSalary(emp.getSalary());
		
		Employee updatedEmp = empRepository.save(oldemp);

		return updatedEmp;
	}


	public String deleteEmployee(int i) {
		
		try {
			empRepository.deleteById(i);
		} catch (Exception e) {
			// TODO: handle exception
			return "Employee Not Deleted...";
		}
		
		return "Employee Deleted Succesfully...";
	}


	public Employee getsingleEmployee(int i) {
		
		Optional<Employee> singleEmp = empRepository.findById(i);
		Employee emp = singleEmp.get();
		
		return emp;
	}


	public List<Employee> getAllEmployee() {
		
		List<Employee> allEmp = empRepository.findAll();

		return allEmp;
	}

}
