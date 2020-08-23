package com.jen.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jen.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = sf.getCurrentSession();
		
		try {
			Student student1 = new Student("Jenish","Vaghasia","jenishvaghasia@gmail.com");
			Student student2 = new Student("Saurav","Ghodasara","sg@gmail.com");
			Student student3 = new Student("Hardik","Kotadiya","hk@gmail.com");
			
			session.beginTransaction();
			
			//Persist Data in Table
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//Fetch data from Table
//			Student s1 = session.get(Student.class, 2);
//			
//			System.out.println(s1.toString());
			
			//Querying Object with Hibernate
//			List<Student> theStudents = session.createQuery("from Student").getResultList();		
//			displayStudent(theStudents);
//			
//			theStudents = session.createQuery("from Student s where s.lastName = 'Vaghasia' OR s.lastName = 'Ghodasara' ").getResultList();
//			displayStudent(theStudents);
			
			
			//Update record in DB
//			Student s1 = session.get(Student.class, 2);
//			s1.setFirstName("AAA");
			
			//Update by Query
//			session.createQuery("update Student set email='abc@gmail.com'").executeUpdate();
			
			//Delete record from  DB
//			Student s1 = session.get(Student.class, 2);
//			session.delete(s1);
			
			//Delete from query
//			session.createQuery("delete from Student where id=5").executeUpdate();
			
			
			session.getTransaction().commit();
			
		}
		finally {
			sf.close();
		}
		
		
	}

	private static void displayStudent(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
