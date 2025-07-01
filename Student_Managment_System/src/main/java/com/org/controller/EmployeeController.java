package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.entity.Employee;
import com.org.exception.CustomException;
import com.org.service.EmployeeService;
import com.org.utils.ApiResponse;

@Controller
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<ApiResponse<Employee>> insertEmployee(@RequestBody Employee emp) {
		
        if (emp.getName() == null || emp.getName().isBlank()) {
            throw new CustomException("Employee name is required", 400, List.of("Name field is blank"));
        }

        Employee addedEmp = empService.addEmployee(emp);

        ApiResponse<Employee> response = new ApiResponse<>(201, addedEmp, "Employee added successfully");
        return ResponseEntity.status(201).body(response);
    }
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable("id") int i, @RequestBody Employee emp) {
		
        if (emp.getName() == null || emp.getName().isBlank()) {
            throw new CustomException("Employee name is required", 400, List.of("Name field is blank"));
        }
        
        
        Employee updatedEmp = empService.updateEmployee(i,emp);

        ApiResponse<Employee> response = new ApiResponse<>(201, updatedEmp, "Employee Detail Updated successfully");
        return ResponseEntity.status(201).body(response);
    }
	
	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<ApiResponse<Employee>> deleteEmployee(@PathVariable("id") int i) {    
        
        String updatedEmp = empService.deleteEmployee(i);

        ApiResponse<Employee> response = new ApiResponse<>(201,null, updatedEmp);
        return ResponseEntity.status(201).body(response);
    }
	
	@GetMapping("/getSingleEmployee/{id}")
	public ResponseEntity<ApiResponse<Employee>> getSingleEmployee(@PathVariable("id") int i) {    
        
        Employee singleEmp = empService.getsingleEmployee(i);

        ApiResponse<Employee> response = new ApiResponse<>(201,singleEmp, "Employee Fetched Succesfully");
        return ResponseEntity.status(201).body(response);
    }
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployee() {
		
	    List<Employee> allEmp = empService.getAllEmployee();
	    
	    ApiResponse<List<Employee>> response = new ApiResponse<>(201, allEmp, "Employees fetched successfully");
	    return ResponseEntity.status(201).body(response);
	}

}
