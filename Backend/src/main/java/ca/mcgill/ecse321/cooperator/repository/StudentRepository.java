package ca.mcgill.ecse321.cooperator.repository;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.cooperator.entity.Student;
import java.util.Date;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	//public Student createStudent(String userEmail, String userPassword, String studentName, int studentId, String school, Date graduationDate);
		
	//public Student getStudent(int studentId);
}