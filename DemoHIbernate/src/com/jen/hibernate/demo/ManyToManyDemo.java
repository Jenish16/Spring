package com.jen.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jen.hibernate.demo.entity.Course;
import com.jen.hibernate.demo.entity.Instructor;
import com.jen.hibernate.demo.entity.InstructorDetail;
import com.jen.hibernate.demo.entity.Review;
import com.jen.hibernate.demo.entity.Student;

public class ManyToManyDemo {


	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Course.class)
							.addAnnotatedClass(Review.class)
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		try {
			session.beginTransaction();
			//Add many student for course
//			Course tempCourse = new Course("Pacman - Hoe score more");
//			
//			session.save(tempCourse);
//			
//			Student tempStudent1 = new Student("JenishS","Vaghasia","jenishvaghasia@gmail.com");
//			Student tempStudent2 = new Student("SauravS","Ghodasara","sg@gmail.com");
//			
//			tempCourse.addStudent(tempStudent1);
//			tempCourse.addStudent(tempStudent2);
//			
//			session.save(tempStudent1);
//			session.save(tempStudent2);
			
			
			//Add many course for student
//			int theId = 1;
//			Student tempStudent = session.get(Student.class, theId);		
//			
//			Course tempCourse1 = new Course("Rubic Cube - Speed");
//			Course tempCourse2 = new Course("Computer - Software");
//			
//			tempCourse1.addStudent(tempStudent);
//			tempCourse2.addStudent(tempStudent);
//
//			session.save(tempCourse1);
//			session.save(tempCourse2);
			
			
			//Get Courses from Student
//			int theId = 1;
//			Student tempStudent = session.get(Student.class,theId);
//			
//			System.out.println("Student:"+tempStudent);
//			System.out.println("Courses:"+tempStudent.getCourses());
			
			//Delete Course
//			int theId = 16;
//			Course tempCourse = session.get(Course.class, theId);
//			
//			session.delete(tempCourse);
			
			//Delete Student
			int theID = 2;
			Student tempStudent = session.get(Student.class,theID);
			
			session.delete(tempStudent);
			
			session.getTransaction().commit();
			
		}catch(Exception exc) {
			exc.printStackTrace();
			
		}finally {
			session.close();
			sf.close();
		}
	}
}
