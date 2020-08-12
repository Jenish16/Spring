package com.jen.spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValiidator 
				implements ConstraintValidator<CourseCode,String> {

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String theCoode, ConstraintValidatorContext theConstraintValidatorContext) {
		
		boolean result;
		if(theCoode != null) {
			result = theCoode.startsWith(coursePrefix);
		}else {
			return true;
		}
			
		return result;
	}
	

}
