package ca.mcgill.ecse321.cooperator.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.cooperator.entity.CoopAdmin;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ca.mcgill.ecse321.cooperator.repository.CoopTermRepository;


@Repository
public class CoopTermService {

	@Autowired
	CoopTermRepository coopTermRepository;

	@SuppressWarnings("deprecation")
	@Transactional
    public CoopTerm createCoopTerm(String location, Date startDate, String academicSemester, boolean ifWorkPermitNeeded,
			String jobDescription, Student student, Employer employer, CoopAdmin coopAdmin, Date endDate) {
		CoopTerm p = new CoopTerm( );

		if (location == null || location.trim().length() == 0) {
			throw new IllegalArgumentException("Location cannot be empty!");
		}
		
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
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
		if (student == null ) {
			throw new IllegalArgumentException("student cannot be empty!");
		}
		if (employer == null ) {
			throw new IllegalArgumentException("employer cannot be empty!");
		}
		if (coopAdmin == null ) {
			throw new IllegalArgumentException("coopAdmin cannot be empty!");
		}
		
		
		if (endDate == null) {
			throw new IllegalArgumentException("End date cannot be empty!");
		}
//		if (endCal.get(Calendar.MONTH) < 1 || endCal.get(Calendar.MONTH) > 12 ) {
//			throw new IllegalArgumentException("end date should be a valid month!");
//		}
//		if (endCal.get(Calendar.YEAR) < 1950) {
//			throw new IllegalArgumentException("end date should be a valid year!");
//		}
		
		p.setLocation(location);
		p.setStartDate(startDate);
		p.setAcademicSemester(academicSemester);
		p.setIfWorkPermitNeeded(ifWorkPermitNeeded);
		p.setJobDescription(jobDescription);
		p.setStudent(student);
		p.setEmployer(employer);
		p.setCoopAdmin(coopAdmin);
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
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
}