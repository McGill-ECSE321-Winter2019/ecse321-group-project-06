package ca.mcgill.ecse321.cooperator.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.CoopTermStates;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Student;
import ca.mcgill.ecse321.cooperator.repository.CoopTermRepository;
import ca.mcgill.ecse321.cooperator.repository.EmployerRepository;
import ca.mcgill.ecse321.cooperator.repository.StudentRepository;


@Service
public class CoopTermService {

	@Autowired
	CoopTermRepository coopTermRepository;
	@Autowired
	EmployerRepository employerRepository;
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	EmployerService employerService;
	@Autowired
	StudentService studentService;

	/**
	 * create a coopTerm 
	 * check the input and throws exception if validation fails
	 *  
	 * @param location
	 * @param startDate
	 * @param academicSemester
	 * @param ifWorkPermitNeeded
	 * @param jobDescription
	 * @param employerId
	 * @param endDate
	 * @param studentId
	 * @param state
	 * @return CoopTerm pReturn
	 */
	@SuppressWarnings("deprecation")
	@Transactional
    public CoopTerm createCoopTerm(String location, Date startDate, String academicSemester, boolean ifWorkPermitNeeded,
			String jobDescription, int employerId, Date endDate, int studentId, CoopTermStates state) 
	{
		CoopTerm p = new CoopTerm( );

		if (location == null || location.trim().length() == 0) {
			throw new IllegalArgumentException("Location cannot be empty!");
		}
		if (startDate == null) {
			throw new IllegalArgumentException("Start date cannot be empty!");
		}
		if (academicSemester == null || academicSemester.trim().length() == 0) {
			throw new IllegalArgumentException("AcademicSemester cannot be empty!");
		}
		if (jobDescription == null || jobDescription.trim().length() == 0) {
			throw new IllegalArgumentException("JobDescription cannot be empty!");
		}
		if (endDate == null) {
			throw new IllegalArgumentException("End date cannot be empty!");
		}

		Employer e = employerRepository.findById(employerId); 
		if(e == null) {
			throw new IllegalArgumentException("employer does not exist!");
		}
		
		Student s = studentRepository.findById(studentId);
		if(s == null) {
			throw new IllegalArgumentException("student does not exist!");
		}
		
		p.setLocation(location);
		p.setStartDate(startDate);
		p.setAcademicSemester(academicSemester);
		p.setIfWorkPermitNeeded(ifWorkPermitNeeded);
		p.setJobDescription(jobDescription);
		p.setEmployer(e);
		p.setEndDate(endDate);
		p.setStudent(s);
		p.setState(state);
		
		employerRepository.save(e);
		studentRepository.save(s);
	    CoopTerm pReturn = coopTermRepository.save(p);
		
	    
		return pReturn;
	}

	/**
	 * get a coopterm by id
	 * throws exception if the coopterm is not found
	 * 
	 * @param coopTermId
	 * @return CoopTerm s
	 */
	@Transactional
	public CoopTerm getCoopTerm(int coopTermId) {
		
		CoopTerm s = coopTermRepository.findById(coopTermId);
		if (s == null) {
			throw new IllegalArgumentException("Coopterm doesn't exist!");
		}
	    
		return s;
	}
	
	/**
	 * update the coopTerm with the coopterm id
	 * throws exception if the coopterm is not found
	 * return updated coopterm
	 * 
	 * @param coopTermId
	 * @param newCoopTerm
	 * @return CoopTerm s
	 */
	@Transactional
	public CoopTerm updateCoopTerm(int coopTermId, CoopTerm newCoopTerm) {
		
		if(newCoopTerm == null) {
			throw new IllegalArgumentException("invalid newCoopTerm!");
		}
		
		CoopTerm s = coopTermRepository.findById(coopTermId);
		if (s == null) {
			throw new IllegalArgumentException("Coopterm doesn't exist!");
		}
		s.setState(newCoopTerm.getState());
		s.setEvaluationForm(newCoopTerm.getEvaluationForm());
		coopTermRepository.save(s);
		return s;
	}
	
	/**
	 * get all coopterms
	 * 
	 * @return List<CoopTerm>
	 */
	@Transactional
	public List<CoopTerm> getAllCoopTerms() {
		return toList ( coopTermRepository.findAll());
	}
	
	/**
	 * get a list of cooopterms of an employer 
	 * 
	 * @param userId
	 * @return List<CoopTerm>
	 */
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
	
	/**
	 * get a list of coopterms of a student
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional
	public List<CoopTerm> getAllCoopTermsOfAnStudent(int userId) {
		List<CoopTerm> allCoopTerms = getAllCoopTerms();
		
		List<CoopTerm> coopTermsOfStudent = new ArrayList<CoopTerm>();
		for (CoopTerm coopTerm: allCoopTerms){
			if (coopTerm.getStudent().getCoopUserId() == userId) {
				coopTermsOfStudent.add(coopTerm);
			}
		}
		if (coopTermsOfStudent.isEmpty()) {
			throw new IllegalArgumentException("There is no coop terms for this employer!");
		}
		return coopTermsOfStudent;
	}
	
	/**
	 * convert iterable to List
	 * @param iterable
	 * @return List<CoopTemr>
	 */
	private List<CoopTerm> toList(Iterable<CoopTerm> iterable){
		List<CoopTerm> resultList = new ArrayList<CoopTerm>();
		for (CoopTerm t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
}