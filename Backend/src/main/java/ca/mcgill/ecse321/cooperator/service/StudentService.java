package ca.mcgill.ecse321.cooperator.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ca.mcgill.ecse321.cooperator.entity.Student;
import java.util.Calendar;
import java.util.List;

import ca.mcgill.ecse321.cooperator.repository.StudentRepository;


@Repository
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Transactional
	public Student createStudent(String userEmail, String userPassword, String studentName, int studentId, String school, Calendar graduationDate) {
		Student s = new Student(userEmail, userPassword, studentName, studentId, school, graduationDate);

		if (userEmail == null || userEmail.trim().length() == 0) {
			throw new IllegalArgumentException("Email cannot be empty!");
		}
		if (userPassword == null || userPassword.trim().length() == 0) {
			throw new IllegalArgumentException("password cannot be empty!");
		}
		if (studentName == null || studentName.trim().length() ==0) {
			throw new IllegalArgumentException("Student name cannot be empty!");
		}
		if (String.valueOf(studentId).length() < 1) {
			throw new IllegalArgumentException("Student name cannot be empty!");
		}
		if (school == null || school.trim().length() ==0) {
			throw new IllegalArgumentException("school entry cannot be empty!");
		}
		if (graduationDate == null) {
			throw new IllegalArgumentException("Graduation date cannot be empty!");
		}
		if (graduationDate.get(Calendar.MONTH) < 1 || graduationDate.get(Calendar.MONTH) > 12 ) {
			throw new IllegalArgumentException("graduation date should be a valid month!");
		}
		if (graduationDate.get(Calendar.YEAR) < 1950) {
			throw new IllegalArgumentException("graduation date should be a valid year!");
		}
		
		s.setEmail(userEmail);
		s.setPassword(userPassword);
		s.setName(studentName);
		s.setStudentId(studentId);
		s.setSchool(school);
		s.setGraduationDate(graduationDate);
		Student sReturn = studentRepository.save(s);
		
		return sReturn;
	}

	@Transactional
	public Student getStudent(int studentId) {
		if (String.valueOf(studentId).length() < 1) {
	        throw new IllegalArgumentException("Student Id cannot be empty!");
	    }
		Student s = studentRepository.findById(studentId).get();
		return s;
	}
	
	@Transactional
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}
}