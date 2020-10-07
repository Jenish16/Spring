package com.jen.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jen.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students")
	public List<Student> getStudents(){
		
		List<Student> theStudent = new ArrayList<>();
		
		 theStudent.add(new Student("Jenish","Vaghasia"));
		 theStudent.add(new Student("Saurav","Ghodasara"));
		 theStudent.add(new Student("Hardik","Kotadiya"));
		
		
		return theStudent;
	
	}
	
}
