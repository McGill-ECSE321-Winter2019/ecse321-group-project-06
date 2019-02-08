package ca.mcgill.ecse321.cooperator.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.cooperator.entity.Student;
import ca.mcgill.ecse321.cooperator.entity.Student.Date;


@Repository
public class StudentRepository {
	
	@Autowired
	EntityManager entityManager;

	@Transactional
	public Student createStudent(String userEmail, String userPassword, String studentName, int studentId, String school, Date graduationDate) {
		//super(userEmail, userPassword, studentName);
		Student s = new Student(userEmail, userPassword, studentName, studentId, school, graduationDate);
		entityManager.persist(s);
		return s;
	}


	
}
