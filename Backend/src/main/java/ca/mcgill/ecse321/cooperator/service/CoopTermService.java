package ca.mcgill.ecse321.cooperator.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.cooperator.entity.CoopAdmin;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Student;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ca.mcgill.ecse321.cooperator.repository.CoopTermRepository;


@Repository
public class CoopTermService {

	@Autowired
	CoopTermRepository coopTermRepository;

	@Transactional

	public CoopTerm createCoopTerm(String location, Date startDate, String academicSemester, boolean ifWorkPermitNeeded,
			String jobDescription, Student student, Employer employer, CoopAdmin coopAdmin, Date endDate) {
		CoopTerm s = new CoopTerm( location, startDate, academicSemester, ifWorkPermitNeeded,
				jobDescription, student,  employer, coopAdmin,  endDate);

		if (location == null || location.trim().length() == 0) {
			throw new IllegalArgumentException("Location cannot be empty!");
		}
		
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		if (startDate == null) {
			throw new IllegalArgumentException("Start date cannot be empty!");
		}
		if (startCal.get(Calendar.MONTH) < 1 || startCal.get(Calendar.MONTH) > 12 ) {
			throw new IllegalArgumentException("start date should be a valid month!");
		}
		if (startCal.get(Calendar.YEAR) < 1950 || startCal.get(Calendar.YEAR) > 2020) {
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
		
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);
		if (endDate == null) {
			throw new IllegalArgumentException("End date cannot be empty!");
		}
		if (endCal.get(Calendar.MONTH) < 1 || endCal.get(Calendar.MONTH) > 12 ) {
			throw new IllegalArgumentException("end date should be a valid month!");
		}
		if (endCal.get(Calendar.YEAR) < 1950) {
			throw new IllegalArgumentException("end date should be a valid year!");
		}
		
		s.setLocation(location);
		s.setStartDate(startDate);
		s.setAcademicSemester(academicSemester);
		s.setIfWorkPermitNeeded(ifWorkPermitNeeded);
		s.setJobDescription(jobDescription);
		s.setStudent(student);
		s.setEmployer(employer);
		s.setCoopAdmin(coopAdmin);
		s.setEndDate(endDate);
		
	    CoopTerm sReturn = coopTermRepository.save(s);
		
		return sReturn;
	}

	@Transactional
	public CoopTerm getCoopTerm(int coopTermId) {
		if (String.valueOf(coopTermId).length() < 1) {
	        throw new IllegalArgumentException("Coop Term Id cannot be empty!");
	    }
		CoopTerm s = coopTermRepository.findById(coopTermId).get();
		return s;
	}
	
	@Transactional
	public List<CoopTerm> getAllCoopTerms() {
		return (List<CoopTerm>) coopTermRepository.findAll();
	}
	
}