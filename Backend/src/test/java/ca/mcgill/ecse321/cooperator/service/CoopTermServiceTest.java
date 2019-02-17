package ca.mcgill.ecse321.cooperator.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.repository.CoopTermRepository;
import ca.mcgill.ecse321.cooperator.repository.EmployerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoopTermServiceTest {
	@Autowired
	private CoopTermService coopTermService;
	@Autowired
	private CoopTermRepository coopTermRepository;
	@Autowired
	private EmployerService employerService;
	@Autowired
	private EmployerRepository employerRepository;
	
	
	@After
	public void clearDatabase() {	
		coopTermService.clearAllCoopTerms();
	}
	

	@Test
	public void testCreateCoopTerm() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());

		String location = "Mcgill";
		Date startDate = new Date();
		startDate.setYear(2019);
		startDate.setMonth(1);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Employer employer= employerService.createEmployer("company@gmail.com","wq","Amazon");
		Date endDate = new Date();
		endDate.setYear(2019);
		endDate.setMonth(1);


		CoopTerm coopTerm = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<CoopTerm> allCoopTerms = coopTermService.getAllCoopTerms();

		assertEquals(1, allCoopTerms.size());
	
		assertEquals(location, coopTerm.getLocation());
		assertEquals(startDate, coopTerm.getStartDate());
		assertEquals(academicSemester, coopTerm.getAcademicSemester());
		assertEquals(ifWorkPermitNeeded, coopTerm.isIfWorkPermitNeeded());
		assertEquals(jobDescription, coopTerm.getJobDescription());
		assertEquals(employer, coopTerm.getEmployer());
		assertEquals(endDate, coopTerm.getEndDate());
		
	}
	
	@Test
	public void testCreateCoopTermWithNullLocation() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = null;
		Date startDate = new Date();
		startDate.setYear(2019);
		startDate.setMonth(1);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Employer employer= employerService.createEmployer("company@gmail.com","wq","Amazon");
		Date endDate = new Date();
		endDate.setYear(2019);
		endDate.setMonth(1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
			assertEquals("Location cannot be empty!", error);
			assertEquals(0, coopTermService.getAllCoopTerms().size());
			return; 
		}
	}

	
	@Test
	public void testCreateCoopTermWithNullStartDate() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = new Date();
		startDate =null;
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Employer employer= employerService.createEmployer("company@gmail.com","wq","Amazon");
		Date endDate = new Date();
		endDate.setYear(2019);
		endDate.setMonth(1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Start date cannot be empty!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	

	@Test
	public void testCreateCoopTermWithWrongStartDateYear() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = new Date();
		startDate.setYear(2021);
		startDate.setMonth(1);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Employer employer= employerService.createEmployer("company@gmail.com","wq","Amazon");
		Date endDate = new Date();
		endDate.setYear(2);
		endDate.setMonth(1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("start date should be a valid year!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithNullAcademicSemester() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "mcgill";
		Date startDate = new Date();
		startDate.setYear(2019);
		startDate.setMonth(1);
		String academicSemester= null;  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Employer employer= employerService.createEmployer("company@gmail.com","wq","Amazon");
		Date endDate = new Date();
		endDate.setYear(2019);
		endDate.setMonth(1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("AcademicSemester cannot be empty!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithNullJobDescription() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "mcgill";
		Date startDate = new Date();
		startDate.setYear(2019);
		startDate.setMonth(1);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= null;
		Employer employer= employerService.createEmployer("company@gmail.com","wq","Amazon");
		Date endDate = new Date();
		endDate.setYear(2019);
		endDate.setMonth(1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("JobDescription cannot be empty!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithNullEmployer() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "mcgill";;
		Date startDate = new Date();
		startDate.setYear(2019);
		startDate.setMonth(1);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Employer employer= null;
		Date endDate = new Date();
		endDate.setYear(2019);
		endDate.setMonth(1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("employer cannot be empty!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	
	@Test
	public void testCreateCoopTermWithNullEndDate() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "mcgill";;
		Date startDate = new Date();
		startDate.setYear(2019);
		startDate.setMonth(1);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Employer employer= employerService.createEmployer("company@gmail.com","wq","Amazon");
		Date endDate = null;

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("End date cannot be empty!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithWrongEndDateYear() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		
		Date startDate = new Date(2012,12,01);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Employer employer= employerService.createEmployer("company@gmail.com","wq","Amazon");
		Date endDate = new Date(202,5,1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("end date should be a valid year!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
}
