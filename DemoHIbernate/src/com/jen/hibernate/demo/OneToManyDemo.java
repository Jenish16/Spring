package com.jen.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jen.hibernate.demo.entity.Course;
import com.jen.hibernate.demo.entity.Instructor;
import com.jen.hibernate.demo.entity.InstructorDetail;
import com.jen.hibernate.demo.entity.Review;

public class OneToManyDemo {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(InstructorDetail.class)
							.addAnnotatedClass(Course.class)
							.addAnnotatedClass(Review.class)
							.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		try {
			session.beginTransaction();
			
//			Instructor tempInstructor = 
//					new Instructor("Hardik","Kotadiya","hk@gmail.com");
//			
//			InstructorDetail tempoInstructorDetail =
//					new InstructorDetail("http://hihi.com/youtube","Games");
//			
//			tempInstructor.setInstructorDetail(tempoInstructorDetail);
//			
//			session.save(tempInstructor);
			
			//add courses to instructor
//			int theId = 1;
//			Instructor tempInstructor = session.get(Instructor.class, theId);
//			
//			Course tempCourse1 = new Course("aaa");
//			Course tempCourse2 = new Course("bbb");
//			
//			
//			tempInstructor.add(tempCourse1);
//			tempInstructor.add(tempCourse2);
//			
//			session.save(tempCourse1);
//			session.save(tempCourse2);
			
//			System.out.println(tempInstructor);
//			System.out.println(tempInstructor.getCourses());
			
//			int theId = 12;
//			Course tempCoures = session.get(Course.class, theId);
//			
//			System.out.println(tempCoures);
//			if(tempCoures != null) {
//				session.delete(tempCoures);
//			}
			
			
			//One to Many Uni-Directional
//			Course tempCourse = new Course("Pacman"); 
//			tempCourse.addReview(new Review("Great"));
//			tempCourse.addReview(new Review("Cool"));
//			tempCourse.addReview(new Review("dumb"));
//			
//			session.save(tempCourse);
			
			int theId = 13;
			Course tempCourse = session.get(Course.class,theId );
			
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			session.delete(tempCourse);
			
			session.getTransaction().commit();
			
		}catch(Exception exc) {
			exc.printStackTrace();
			
		}finally {
			session.close();
			sf.close();
		}
		
		
	}

}
