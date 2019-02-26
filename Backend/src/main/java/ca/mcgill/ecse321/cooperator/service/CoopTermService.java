package ca.mcgill.ecse321.cooperator.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ca.mcgill.ecse321.cooperator.repository.CoopTermRepository;


@Service
public class CoopTermService {

	@Autowired
	CoopTermRepository coopTermRepository;
	@Autowired
	EmployerService employerService;
	@Autowired
	StudentService studentService;

	/* exceptions */
	@SuppressWarnings("deprecation")
	@Transactional
    public CoopTerm createCoopTerm(String location, Date startDate, String academicSemester, boolean ifWorkPermitNeeded,
			String jobDescription, Employer employer, Date endDate, Student student) 
	{
		CoopTerm p = new CoopTerm( );

		if (location == null || location.trim().length() == 0) {
			throw new IllegalArgumentException("Location cannot be empty!");
		}
		if (startDate == null) {
			throw new IllegalArgumentException("Start date cannot be empty!");
		}
		if (startDate.getMonth() < 0 || startDate.getMonth() > 11 ) {
			throw new IllegalArgumentException("start date should be a valid month!");
		}
		if (startDate.getYear() < 1950 || startDate.getYear() > 2020) {
			throw new IllegalArgumentException("start date should be a valid year!");
		}
		if (academicSemester == null || academicSemester.trim().length() == 0) {
			throw new IllegalArgumentException("AcademicSemester cannot be empty!");
		}
		if (ifWorkPermitNeeded != true && ifWorkPermitNeeded != false ) {
			throw new IllegalArgumentException("ifWorkPermitNeeded must be boolean!");
		}
		if (jobDescription == null || jobDescription.trim().length() == 0) {
			throw new IllegalArgumentException("JobDescription cannot be empty!");
		}
		if (employer == null ) {
			throw new IllegalArgumentException("employer cannot be empty!");
		}
		if (endDate == null) {
			throw new IllegalArgumentException("End date cannot be empty!");
		}
		if (endDate.getMonth() < 0 || endDate.getMonth() > 11 ) {
			throw new IllegalArgumentException("end date should be a valid month!");
		}
		if (endDate.getYear() < 1950) {
			throw new IllegalArgumentException("end date should be a valid year!");
		}
		if (student == null) {
			throw new IllegalArgumentException("student cannot be empty!");
		}
		
		p.setLocation(location);
		p.setStartDate(startDate);
		p.setAcademicSemester(academicSemester);
		p.setIfWorkPermitNeeded(ifWorkPermitNeeded);
		p.setJobDescription(jobDescription);
		p.setEmployer(employer);
		p.setEndDate(endDate);
		p.setStudent(student);
		
	    CoopTerm pReturn = coopTermRepository.save(p);
		
		return pReturn;
	}

	/* id getter */
	@Transactional
	public CoopTerm getCoopTerm(int coopTermId) {
		
		CoopTerm s = coopTermRepository.findById(coopTermId);
		if (s == null) {
			throw new IllegalArgumentException("Coop term cannot found!");
		}
		
		return s;
	}
	
	/* get coopterms list */
	@Transactional
	public List<CoopTerm> getAllCoopTerms() {
		return toList ( coopTermRepository.findAll());
	}
	
	/* get all the coop terms in charge by an employer */
	@Transactional
	public List<CoopTerm> getAllCoopTermOfAnEmployer(int userId) {
		List<CoopTerm> allCoopTerms = getAllCoopTerms();
		
		List<CoopTerm> coopTermsOfEmployer = new ArrayList<CoopTerm>();
		for (CoopTerm coopTerm: allCoopTerms){
			if (coopTerm.getEmployer().getCoopUserId() == userId) {
				coopTermsOfEmployer.add(coopTerm);
			}
		}
		if (coopTermsOfEmployer.isEmpty()) {
			throw new IllegalArgumentException("There is no coop terms for this employer!");
		}
		return coopTermsOfEmployer;
	}
	

	/* get all coop terms from a student */
	@Transactional 
	public List<CoopTerm> getCoopTermsofStudent(int employerId, int studentId) {
		//Find the student by studentId
		List<Student> allStudents = studentService.getAllStudentsOfAnEmployer(employerId);
		Student targetStudent = null;
		for (Student student: allStudents) {
			if (student.getCoopUserId() == studentId) {
				targetStudent = student;
			}
		}
		//find all the coop terms related to this student 
		List<CoopTerm> allCoopTerms = getAllCoopTermOfAnEmployer(employerId);
		List<CoopTerm> coopTermsOfStudent = new ArrayList<CoopTerm>();
		for (CoopTerm coopTerm: allCoopTerms) {
			if (coopTerm.getStudent().getCoopUserId() == studentId) {
				coopTermsOfStudent.add(coopTerm);
			}		
		}
		return coopTermsOfStudent;
	}
	
	/* get a specific coop term from a student */
	@Transactional
	public CoopTerm getOneCoopTermOfStudent(int employerId, int studentId, int coopTermId) {
		List<CoopTerm> coopTermsOfStudent = getCoopTermsofStudent(employerId,studentId);
		CoopTerm getCoopTerm = null;
		for (CoopTerm coopTerm: coopTermsOfStudent) {
			if(coopTerm.getcoopTermId() == coopTermId) {
				getCoopTerm = coopTerm;
			}
		}
		return getCoopTerm;
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
}