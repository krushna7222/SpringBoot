package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudService;

@Controller
public class StudentCOntroller {

	@Autowired
	StudService service;
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		Student student= new Student();
		
		   model.addAttribute("student",student);
		   
		   return "create-student";
		
	}
	
	
	@PostMapping("/students")
	public String SubmitData(@ModelAttribute ("student")  Student s1)
	{
		   service.saveStudent(s1);
		return "redirect:/students";
	}
	
	
	// handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		
		List<Student> list =service.getAllStudents();
		model.addAttribute("stud", list);
		return "students";  //students.html
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {

//		          Student s1  = service.getStudentById(id);
//		      model.addAttribute("student",s1);
		          
		          model.addAttribute("student",service.getStudentById(id));
		          
		return "edit_student";
	}
	
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model) {
		
		// get student from database by id
		Student existingStudent = service.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object
		service.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudentById(id);
		return "redirect:/students";
	}
	
	
}
