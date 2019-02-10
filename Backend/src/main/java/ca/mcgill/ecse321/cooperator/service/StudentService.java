package ca.mcgill.ecse321.cooperator.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.cooperator.entity.Student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ca.mcgill.ecse321.cooperator.repository.StudentRepository;


@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Transactional
	public Student createStudent(String userEmail, String userPassword, String studentName, int studentId, String school, Calendar graduationMonth, Calendar graduationYear) {
		
		if (userEmail == null || userEmail.trim().length() == 0) {
			throw new IllegalArgumentException("Email cannot be empty!");
		}
		if (userPassword == null || userPassword.trim().length() == 0) {
			throw new IllegalArgumentException("password cannot be empty!");
		}
		if (studentName == null || studentName.trim().length() ==0) {
			throw new IllegalArgumentException("Student name cannot be empty!");
		}
		if (String.valueOf(studentId).length() <= 1) {
			throw new IllegalArgumentException("Student Id should be more than 1 digit!");
		}
		if (school == null || school.trim().length() == 0) {
			throw new IllegalArgumentException("school entry cannot be empty!");
		}
		if (graduationMonth == null) {
			throw new IllegalArgumentException("Graduation Month cannot be empty!");
		}
		if (graduationYear == null) {
			throw new IllegalArgumentException("Graduation Year cannot be empty!");
		}
		if (graduationYear.get(Calendar.YEAR) < 1950) {
			throw new IllegalArgumentException("graduation date should be a valid year!");
		}
		//Student s = new Student(studentId, school, graduationMonth, graduationYear);
		Student s = new Student();
		s.setEmail(userEmail);
		s.setPassword(userPassword);
		s.setName(studentName);
		s.setStudentId(studentId);
		s.setSchool(school);
		s.setGraduationMonth(graduationMonth);
		s.setGraduationYear(graduationYear);
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
		return toList (studentRepository.findAll());
	}
	
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
}