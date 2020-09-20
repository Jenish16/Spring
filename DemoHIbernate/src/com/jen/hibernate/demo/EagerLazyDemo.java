package com.jen.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jen.hibernate.demo.entity.Course;
import com.jen.hibernate.demo.entity.Instructor;
import com.jen.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Course.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		try {
			
			session.beginTransaction();
			
			int theId = 1;
//			Instructor tempInstructor = session.get(Instructor.class, theId);
			
//			System.out.println(tempInstructor);
//			
//			System.out.println(tempInstructor.getCourses());
			
			//To resolve Lazy loading exception on session close
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i"
										+ " JOIN FETCH i.courses"
										+ " WHERE i.id = :theInstructorId",
							Instructor.class);
			query.setParameter("theInstructorId", theId);
			
			Instructor tempInstructor = query.getSingleResult();  //Load instructor and Courses in memory at same time
					
			session.getTransaction().commit();
			session.close();
			
			System.out.println(tempInstructor);
			
			System.out.println(tempInstructor.getCourses());
			
		}catch(Exception exc) {
			exc.printStackTrace();
			
		}finally {
			session.close();
			sf.close();
		}
		
		
	}
}