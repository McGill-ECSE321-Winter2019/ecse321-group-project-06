package ca.mcgill.ecse321.cooperator.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Student;
import ca.mcgill.ecse321.cooperator.repository.StudentRepository;
import ca.mcgill.ecse321.cooperator.service.CoopTermService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CoopTermService coopTermService;

	/*exceptions*/
	@SuppressWarnings("deprecation")
	@Transactional
	public Student createStudent(String userEmail, String userPassword, String studentName, int studentId, String school, Date graduationDate) {

		Student s = new Student();
		if (userEmail == null || userEmail.trim().length() == 0) {
			throw new IllegalArgumentException("Email cannot be empty!");
		}
		if (userPassword == null || userPassword.trim().length() == 0) {
			throw new IllegalArgumentException("password cannot be empty!");
		}
		if (studentName == null || studentName.trim().length() ==0) {
			throw new IllegalArgumentException("Student name cannot be empty!");
		}
		if (school == null || school.trim().length() == 0) {
			throw new IllegalArgumentException("school entry cannot be empty!");
		}
		if (graduationDate == null) {
			throw new IllegalArgumentException("Graduation Month cannot be empty!");
		}
		if (graduationDate.getYear() < 1950) {
			throw new IllegalArgumentException("graduation date should be a valid year!");
		}

		s.setEmail(userEmail);
		s.setPassword(userPassword);
		s.setName(studentName);
		s.setSchool(school);
		s.setGraduationDate(graduationDate);
		Student sReturn = studentRepository.save(s);

		return sReturn;
	}

	/* id getter */
	@Transactional
	public Student getStudent(int studentId) {
		if(studentId <0) {
			throw new IllegalArgumentException("invalid id input!");
		}
		Student s = studentRepository.findById(studentId);
		if (s == null) {
			throw new IllegalArgumentException("Student cannot found!");
		}
		return s;
	}

	/* get all students in the list */
	@Transactional
	public List<Student> getAllStudents() {
		return toList (studentRepository.findAll());
	}
	
	
	
	/* Get all the students in charged by an employer */
	@Transactional
	public List<Student> getAllStudentsOfAnEmployer (int employerId) {
		List<CoopTerm> allCoopTermsOfEmployer = coopTermService.getAllCoopTermOfAnEmployer(employerId);
		//use set to avoid duplicate student
		Set<Student> allStudentsOfEmployer = new HashSet<Student>();
		for (CoopTerm coopTerm: allCoopTermsOfEmployer) {
			allStudentsOfEmployer.add(coopTerm.getStudent());
		}
		List<Student> allStudentsList = new ArrayList<>(allStudentsOfEmployer);
		
		return allStudentsList;
	}
	
	/* iterable method */
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}

} 
