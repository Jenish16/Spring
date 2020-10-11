package com.jen.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jen.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudent;

	@PostConstruct
	public void loadData() {
		
		theStudent = new ArrayList<>();

		theStudent.add(new Student("Jenish","Vaghasia"));
		theStudent.add(new Student("Saurav","Ghodasara"));
		theStudent.add(new Student("Hardik","Kotadiya"));
	}

	@GetMapping("/students")
	public List<Student> getStudents(){

		return theStudent;

	}
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		
		if(studentId >= theStudent.size() || studentId < 0 ) {
			throw new StudentNotFoundException("Student ID not found - " + studentId);
		}
		return theStudent.get(studentId);

	}
	

}
