package ca.mcgill.ecse321.cooperator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import ca.mcgill.ecse321.cooperator.dto.CoopTermDto;
import ca.mcgill.ecse321.cooperator.dto.EmployerDto;
import ca.mcgill.ecse321.cooperator.dto.StudentDto;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Student;
import ca.mcgill.ecse321.cooperator.service.CoopTermService;

@CrossOrigin
@Controller
@RequestMapping("/coopTerm")
public class CoopTermController {
	@Autowired
	private CoopTermService service;
	
	@GetMapping(value = {"/student/{id}", "/student/{id}/"})
	@ResponseBody
	public List<CoopTermDto> getCoopTermsByStudentId(@PathVariable int id){
		List<CoopTermDto> coopTerms = new ArrayList<>();
		for(CoopTerm coopterm: service.getAllCoopTerms()) {
			if(coopterm.getStudent().getCoopUserId() == id) {
				coopTerms.add(convertToCoopTermDto(coopterm));
			}
		}
		return coopTerms;
	}
	
	@GetMapping(value = {"/employer/{employerId}", "/employer/{employerId}/"})
	@ResponseBody 
	public List<CoopTermDto> getCoopTermsByEmployerId(@PathVariable int employerId) {
		List<CoopTermDto> coopTerms = new ArrayList<>();
		for (CoopTerm coopterm: service.getAllCoopTermOfAnEmployer(employerId)) {
				coopTerms.add(convertToCoopTermDto(coopterm));	
		}
		return coopTerms;
	}
	
	@GetMapping(value = { "/{id}", "/{id}/" })
	@ResponseBody
	public CoopTermDto getCoopTermById(@PathVariable int id) {
		CoopTerm coopTerm = service.getCoopTerm(id);
		return convertToCoopTermDto(coopTerm);
	}
	
	@PutMapping(value = {"/{id}", "/{id}/"})
	@ResponseBody
	public CoopTermDto updateCoopTermStateById(@PathVariable int id, @RequestBody CoopTerm coopTerm) {
		CoopTerm updatedCoopTerm = service.updateCoopTerm(id, coopTerm);
		return convertToCoopTermDto(updatedCoopTerm);
	}

	private CoopTermDto convertToCoopTermDto(CoopTerm coopTerm) {
		if(coopTerm == null) {
			throw new IllegalArgumentException("There is no such CoopTerm!");
		}
		Employer employer = coopTerm.getEmployer();
		if(employer == null) {
			throw new IllegalArgumentException("There is no such employer");
		}
		EmployerDto employerDto = convertToEmployerDto(employer);
		Student student = coopTerm.getStudent();
		if(student == null) {
			throw new IllegalArgumentException("There is no such student");
		}
		StudentDto studentDto = convertToStudentDto(student);
		CoopTermDto coopTermDto = new CoopTermDto(coopTerm.getStartDate(), coopTerm.getEndDate(), 
				coopTerm.getLocation(), coopTerm.getAcademicSemester(), coopTerm.isIfWorkPermitNeeded(), 
				coopTerm.getJobDescription(), coopTerm.getEvaluationForm(), coopTerm.getCoopPlacement(), 
				coopTerm.getTaxCreditForm(), coopTerm.getcoopTermId(),  employerDto, studentDto, coopTerm.getState());
		return coopTermDto;
	}
	
	private StudentDto convertToStudentDto(Student student) {
		StudentDto studentDto = new StudentDto(student.getEmail(),student.getPassword(), student.getName(),student.getCoopUserId());
		return studentDto;
	}

	private EmployerDto convertToEmployerDto(Employer employer) {
		EmployerDto employerDto = new EmployerDto(employer.getEmail(), employer.getPassword(), employer.getName(), employer.getCoopUserId());
		return employerDto;
	}
}
