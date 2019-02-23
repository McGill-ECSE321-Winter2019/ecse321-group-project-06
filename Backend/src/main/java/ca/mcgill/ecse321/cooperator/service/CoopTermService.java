package ca.mcgill.ecse321.cooperator.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.mcgill.ecse321.cooperator.repository.CoopTermRepository;


@Service
public class CoopTermService {

	@Autowired
	CoopTermRepository coopTermRepository;

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
		
		CoopTerm s = coopTermRepository.findById(coopTermId).get();
		return s;
	}
	
	/* get coopterms list */
	@Transactional
	public List<CoopTerm> getAllCoopTerms() {
		return toList ( coopTermRepository.findAll());
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
}