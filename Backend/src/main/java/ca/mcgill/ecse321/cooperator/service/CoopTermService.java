package ca.mcgill.ecse321.cooperator.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ca.mcgill.ecse321.cooperator.repository.CoopTermRepository;


@Service
public class CoopTermService {

	@Autowired
	CoopTermRepository coopTermRepository;

	@SuppressWarnings("deprecation")
	@Transactional
    public CoopTerm createCoopTerm(String location, Date startDate, String academicSemester, boolean ifWorkPermitNeeded,
			String jobDescription, Employer employer, Date endDate) 
	{
		CoopTerm p = new CoopTerm( );

		if (location == null || location.trim().length() == 0) {
			throw new IllegalArgumentException("Location cannot be empty!");
		}
		
		
		if (startDate == null) {
			throw new IllegalArgumentException("Start date cannot be empty!");
		}
		
		if (startDate.getMonth() < 1 || startDate.getMonth() > 12 ) {
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
		
		if (endDate.getMonth() < 1 || endDate.getMonth() > 12 ) {
			throw new IllegalArgumentException("end date should be a valid month!");
		}
		
		if (endDate.getYear() < 1950) {
			throw new IllegalArgumentException("end date should be a valid year!");
		}
		
		p.setLocation(location);
		p.setStartDate(startDate);
		p.setAcademicSemester(academicSemester);
		p.setIfWorkPermitNeeded(ifWorkPermitNeeded);
		p.setJobDescription(jobDescription);
		p.setEmployer(employer);
		p.setEndDate(endDate);
		
	    CoopTerm pReturn = coopTermRepository.save(p);
		
		return pReturn;
	}

	@Transactional
	public CoopTerm getCoopTerm(int coopTermId) {
		
		CoopTerm s = coopTermRepository.findById(coopTermId).get();
		return s;
	}
	
	@Transactional
	public List<CoopTerm> getAllCoopTerms() {
		return toList ( coopTermRepository.findAll());
	}
	
	@Transactional
	public void clearAllCoopTerms() {
		coopTermRepository.deleteAll();
		System.out.println(getAllCoopTerms().size());
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
}