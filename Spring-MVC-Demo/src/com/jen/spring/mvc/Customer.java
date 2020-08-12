package com.jen.spring.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.jen.spring.mvc.validation.CourseCode;

public class Customer {

	private String firstName;
	
	@NotNull(message="is required(Not null msg)")
	@Size(min=1, message="is required(size msg)")
	private String lastName;

	@NotNull(message="is required(Not null msg)")
	@Min(value = 0, message="Must be greater than or equal to zero")
	@Max(value = 10, message="Must be less than or equal to ten")
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="Only 5 Chars/Digit")
	private String postalCode;
	
	@CourseCode(value = "LUV", message = "must start with LUV")
	private String courseCode;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
}
