package com.jen.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON  file and map/convert to Java POJO: 
			// data/sample-lite.json
			
			Student theStudent = mapper.readValue(
						new File("data/sample-full.json"), Student.class);
			
			Address tempAddress = theStudent.getAddress();
			// print first name and last name
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			System.out.println("Address = " + tempAddress);
			System.out.println("Languages = ");
			for(String language : theStudent.getLanguages()) {
				System.out.println("	:" + language);
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}




