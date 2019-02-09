package ca.mcgill.ecse321.cooperator.service;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.cooperator.entity.Student;
import java.util.Date;
import ca.mcgill.ecse321.cooperator.repository.StudentRepository;


@Repository
public class StudentService {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	StudentRepository studentRepository;

	@Transactional
	public Student createStudent(String userEmail, String userPassword, String studentName, int studentId, String school, Date graduationDate) {
		Student s = new Student(userEmail, userPassword, studentName, studentId, school, graduationDate);
		entityManager.persist(s);
		return s;
	}
	
	@Transactional
	public Student getStudent(int studentId) {
		Student s = entityManager.find(Student.class, studentId);
		return s;
	}
	
}