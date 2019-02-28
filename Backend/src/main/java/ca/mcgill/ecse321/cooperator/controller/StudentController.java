package ca.mcgill.ecse321.cooperator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.cooperator.dto.CoopTermDto;
import ca.mcgill.ecse321.cooperator.dto.EmployerDto;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Student;
import ca.mcgill.ecse321.cooperator.service.CoopTermService;
import ca.mcgill.ecse321.cooperator.service.EmployerService;
import ca.mcgill.ecse321.cooperator.service.StudentService;
import ca.mcgill.ecse321.cooperator.dto.StudentDto;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private EmployerService employerService;

	/* Get students of an employer */
	@GetMapping(value = {"/employer/{employerId}/students", "/employer/{employerId}/students/"})
	public List<StudentDto> getStudents(@PathVariable(value = "employerId") int employerId) {
		try {
			Employer employer = employerService.getEmployer(employerId);
		} catch(Exception e){
			throw (e);
		}
		
		List<StudentDto> studentDtos = new ArrayList<>();
	    for (Student student: studentService.getAllStudentsOfAnEmployer(employerId)) {
	    	studentDtos.add(convertToDto(student));
	    }
		return studentDtos;
	}
	
	
	/*convert to Dto method for student*/
	private StudentDto convertToDto(Student s) {
		if (s == null) {
			throw new IllegalArgumentException("There is no such student!");
		}
		StudentDto studentDto = new StudentDto(s.getEmail(),s.getPassword(),s.getName(),s.getCoopUserId());
		return studentDto;
	}
	
}
