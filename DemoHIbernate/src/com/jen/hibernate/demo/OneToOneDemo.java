package com.jen.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jen.hibernate.demo.entity.Instructor;
import com.jen.hibernate.demo.entity.InstructorDetail;

public class OneToOneDemo {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		try {
			session.beginTransaction();
			//Uni Directional
			
//			Instructor tempInstructor = 
//					new Instructor("Jenish","Vaghasia","jenishvaghasia@gmail.com");
//			
//			InstructorDetail tempoInstructorDetail =
//					new InstructorDetail("http://firewithice.com/youtube","Love to Code");
//			
//			Instructor tempInstructor = 
//					new Instructor("Saurav","Ghodosara","sauravghodosara10@gmail.com");
//			
//			InstructorDetail tempoInstructorDetail =
//					new InstructorDetail("http://cricket.com/youtube","Cricket");
			
			
//			tempInstructor.setInstructorDetail(tempoInstructorDetail);
			
				
//			session.save(tempInstructor);
			
//			int theId =2 ;
//			Instructor tempInstructor = session.get(Instructor.class, theId);
//			
//			System.out.println(tempInstructor);
//			if(tempInstructor != null) {
//				session.delete(tempInstructor);
//			}
			
			//Bi Directional
			
//			Instructor tempInstructor = 
//					new Instructor("abc","xyz","abcxyz@gmail.com");
//			
//			InstructorDetail tempInstructorDetail =
//					new InstructorDetail("http://asdqwe.com/youtube","zzzzzz");
//			tempInstructorDetail.setInstructor(tempInstructor);
//			
//			session.save(tempInstructorDetail);
			
			int theId = 6 ;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println(tempInstructorDetail);
			System.out.println(tempInstructorDetail.getInstructor());
			
			session.delete(tempInstructorDetail);
			
			session.getTransaction().commit();
			
			
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}finally {
			session.close();
			sf.close();
		}
		
		
	}

}
