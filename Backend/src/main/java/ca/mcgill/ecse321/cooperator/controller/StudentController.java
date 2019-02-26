package ca.mcgill.ecse321.cooperator.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import ca.mcgill.ecse321.cooperator.service.StudentService;
import ca.mcgill.ecse321.cooperator.dto.StudentDto;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {

	/* Get students of an employer */
	@GetMapping(value = {"/employers/{employerId}/students"})
	public List<StudentDto> getStudents(@PathVariable int employerId) {
		StudentService service = new StudentService();
		List<StudentDto> studentDtos = new ArrayList<>();
	    for (Student student: service.getAllStudentsOfAnEmployer(employerId)) {
	    	studentDtos.add(convertToDto(student));
	    }
		return studentDtos;
	}
	
	/* get all coop terms of a student in charged by an employer */
	@GetMapping(value = {"/employers/{employerId}/students/{studentId}/coopTerms"})
	public List<CoopTermDto> getAllCoopTermsByStudents(@PathVariable(value = "employerId") int employerId,
			@PathVariable(value = "studentId") int studentId, @PathVariable (value = "employers") Employer employers) {
		CoopTermService service = new CoopTermService();
		List<CoopTermDto> coopTermDtos = new ArrayList<>();
		for (CoopTerm coopTerm: service.getCoopTermsofStudent(employerId, studentId)) {
			coopTermDtos.add(convertToDto(coopTerm, employers));
		}
		return coopTermDtos;
	}
	
	/* get a coop term of a student in charged by an employer  */
	@GetMapping(value = {"/employers/{employerId}/students/{studentId}/coopTerms/{coopTermId}"})
	public CoopTermDto getAnCoopTermOfStudent(@PathVariable(value = "employerId") int employerId,
			@PathVariable (value = "studentId") int studentId, @PathVariable(value = "coopTermId")int coopTermId,
			@PathVariable (value = "employers") Employer employers) {
		CoopTermService service = new CoopTermService();
		CoopTerm coopTerm = service.getOneCoopTermOfStudent(employerId, studentId, coopTermId);
		CoopTermDto coopTermDto = convertToDto(coopTerm, employers);
		
		return coopTermDto;
	}
	
	/*convert to Dto method for Employer*/
	private EmployerDto convertToDto(Employer e) {
		if (e == null) {
			throw new IllegalArgumentException("There is no such employer!");
		}
		EmployerDto employerDto = new EmployerDto(e.getEmail(), e.getPassword(),e.getName(),e.getCoopUserId());
		return employerDto;
	}
	
	/*convert to Dto method for student*/
	private StudentDto convertToDto(Student s) {
		if (s == null) {
			throw new IllegalArgumentException("There is no such student!");
		}
		StudentDto studentDto = new StudentDto(s.getEmail(),s.getPassword(),s.getName(),s.getCoopUserId());
		return studentDto;
	}
	
	/*convert to Dto method for coop term*/
	private CoopTermDto convertToDto(CoopTerm t, Employer e) {
		if (e == null) {
			throw new IllegalArgumentException("There is no such Coop term!");
		}
		EmployerDto employerDto  = convertToDto(e);
		CoopTermDto coopTermDto = new CoopTermDto( t.getStartDate(), t.getEndDate(), t.getLocation(),t.getAcademicSemester(),
				t.isIfWorkPermitNeeded(), t.getJobDescription(), t.getEvaluationForm(), t.getCoopPlacement(),
				t.getTaxCreditForm(), t.getcoopTermId(), employerDto);	
		return coopTermDto;
	}
}
