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
			
			
			session.beginTransaction();
			
//			session.save(tempInstructor);
			
			int theId =4 ;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println(tempInstructor);
			if(tempInstructor != null) {
				session.delete(tempInstructor);
			}
						

			
			
			session.getTransaction().commit();
			
			
			
		}finally {
			sf.close();
		}
		
		
	}

}
