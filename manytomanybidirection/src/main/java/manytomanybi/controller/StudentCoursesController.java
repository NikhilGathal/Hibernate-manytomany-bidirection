package manytomanybi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybi.dto.Course;
import manytomanybi.dto.Student;

public class StudentCoursesController {

	public static void main(String[] args) {

//		Student student1 = new Student();
//		student1.setId(1);
//		student1.setName("Nikhil");
//		student1.setAddress("Pune");
//
//		Student student2 = new Student();
//		student2.setId(2);
//		student2.setName("Dope");
//		student2.setAddress("Latur");
//
//		Course course1 = new Course();
//		course1.setId(1);
//		course1.setName("Java");
//		course1.setFees(5000);
//
//		Course course2 = new Course();
//		course2.setId(2);
//		course2.setName("AdvJava");
//		course2.setFees(10000);
//
//		List<Course> course = new ArrayList<Course>();
//		course.add(course1);
//		course.add(course2);
//
//		student1.setCourse(course);
//		student2.setCourse(course);
//
//		List<Student> student = new ArrayList<Student>();
//		student.add(student1);
//		student.add(student2);
//
//		course1.setStudent(student);
//		course2.setStudent(student);
		
		// delete student
			
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		Student dbstudent = entityManager.find(Student.class,1);
//		
//		if(dbstudent != null )
//		{
//			EntityTransaction entityTransaction = entityManager.getTransaction();
//			entityTransaction.begin();
//			entityManager.remove(dbstudent);
//			entityTransaction.commit();
//		}
//		else 
//		{
//			System.out.println("Id not present");
//		}
		
		// delete course
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Course dbcourse = entityManager.find(Course.class,1);
		
		if(dbcourse != null )
		{
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			List<Student> student = dbcourse.getStudent();
			
			for (Student students : student) {
				List<Course> course = students.getCourse();
				//courses sql,java ,advance java
				course.remove(dbcourse);
				//courses sql,advance java 
				students.setCourse(course);
			}
			entityManager.remove(dbcourse);
			entityTransaction.commit();
		}
		else 
		{
			System.out.println("Id not present");
		}

	}

}
