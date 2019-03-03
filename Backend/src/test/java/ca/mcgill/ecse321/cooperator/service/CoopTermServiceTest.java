package ca.mcgill.ecse321.cooperator.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.CoopTermStates;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Student;
import ca.mcgill.ecse321.cooperator.repository.CoopTermRepository;
import ca.mcgill.ecse321.cooperator.repository.EmployerRepository;
import ca.mcgill.ecse321.cooperator.repository.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class CoopTermServiceTest {
	@Autowired
	private CoopTermService coopTermService;
	@Autowired
	private CoopTermRepository coopTermRepository;
	@Autowired
	private EmployerService employerService;
	@Autowired
	private EmployerRepository employerRepository;
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentRepository studentRepository;
	
	@After
	public void clearDatabase() {	
		coopTermRepository.deleteAll();
	}
	
	/* Test whether coopterm can be created successfully*/
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
		Date graduationDate = new Date();
		graduationDate.setYear(2020);
		graduationDate.setMonth(7);
		Student student = studentService.createStudent("student@gmail.com", "abcde", "Oliverrr", 12345, "McGill", graduationDate);
		
		coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
				jobDescription, employer, endDate, student, CoopTermStates.INACTIVE);

		List<CoopTerm> allCoopTerms = coopTermService.getAllCoopTerms();

		assertEquals(1, allCoopTerms.size());
		assertEquals(location, allCoopTerms.get(0).getLocation());
		assertEquals(startDate, allCoopTerms.get(0).getStartDate());
		assertEquals(academicSemester, allCoopTerms.get(0).getAcademicSemester());
		assertEquals(ifWorkPermitNeeded, allCoopTerms.get(0).isIfWorkPermitNeeded());
		assertEquals(jobDescription, allCoopTerms.get(0).getJobDescription());
		assertEquals(employer, coopTerm.getEmployer());
		assertEquals(endDate, allCoopTerms.get(0).getEndDate());
		assertEquals(student, coopTerm.getStudent());
		
	}
	
    /* Test creating coopterm with no location provided, should throw exception */
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
		Date graduationDate = new Date();
		graduationDate.setYear(2020);
		graduationDate.setMonth(7);
		Student student = studentService.createStudent("student@gmail.com", "abcde", "Oliverrr", 12345, "McGill", graduationDate);
		
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate,student, CoopTermStates.ACTIVE);
		} catch (IllegalArgumentException e) {
			error = e.getMessage(); 
		}
		assertEquals("Location cannot be empty!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		return;
	}

	/* Test creating coopterm with no start date provided, should throw exception */
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
		Date graduationDate = new Date();
		graduationDate.setYear(2020);
		graduationDate.setMonth(7);
		Student student = studentService.createStudent("student@gmail.com", "abcde", "Oliverrr", 12345, "McGill", graduationDate);
		
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate,student, CoopTermStates.ACTIVE);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("Start date cannot be empty!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	/* Test creating coopterm with wrong start date year provided, should throw exception */
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
		Date graduationDate = new Date();
		graduationDate.setYear(2020);
		graduationDate.setMonth(7);
		Student student = studentService.createStudent("student@gmail.com", "abcde", "Oliverrr", 12345, "McGill", graduationDate);
		
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate, student, CoopTermStates.ACTIVE);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("start date should be a valid year!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	
	/* Test creating coopterm with no academic semester provided, should throw exception */
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
		Date graduationDate = new Date();
		graduationDate.setYear(2020);
		graduationDate.setMonth(7);
		Student student = studentService.createStudent("student@gmail.com", "abcde", "Oliverrr", 12345, "McGill", graduationDate);
		
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate,student, CoopTermStates.INACTIVE);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("AcademicSemester cannot be empty!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	/* Test creating coopterm with no job description provided, should throw exception */
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
		Date graduationDate = new Date();
		graduationDate.setYear(2020);
		graduationDate.setMonth(7);
		Student student = studentService.createStudent("student@gmail.com", "abcde", "Oliverrr", 12345, "McGill", graduationDate);
		
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate,student, CoopTermStates.INACTIVE);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("JobDescription cannot be empty!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	/* Test creating coopterm with no employer provided, should throw exception */
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
		Date graduationDate = new Date();
		graduationDate.setYear(2020);
		graduationDate.setMonth(7);
		Student student = studentService.createStudent("student@gmail.com", "abcde", "Oliverrr", 12345, "McGill", graduationDate);
		
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate,student, CoopTermStates.INACTIVE);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("employer cannot be empty!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	/* Test creating coopterm with no end date provided, should throw exception */
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
		Date graduationDate = new Date();
		graduationDate.setYear(2020);
		graduationDate.setMonth(7);
		Student student = studentService.createStudent("student@gmail.com", "abcde", "Oliverrr", 12345, "McGill", graduationDate);
		
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate, student, CoopTermStates.ACTIVE);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("End date cannot be empty!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	/* Test creating coopterm with wrong end date year provided, should throw exception */
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
		Date graduationDate = new Date();
		graduationDate.setYear(2020);
		graduationDate.setMonth(7);
		Student student = studentService.createStudent("student@gmail.com", "abcde", "Oliverrr", 12345, "McGill", graduationDate);
		
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate, student, CoopTermStates.ACTIVE);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("end date should be a valid year!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithNullStudent() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = new Date(2012,12,01);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Employer employer= employerService.createEmployer("company@gmail.com","wq","Amazon");
		Date endDate = new Date(2020,5,1);
		CoopTerm coopTerm = null;
		String error = null;
		Date graduationDate = new Date();
		graduationDate.setYear(2020);
		graduationDate.setMonth(7);
		Student student = null;
		
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, employer, endDate, student, CoopTermStates.ACTIVE);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertEquals("student cannot be empty!", error);
		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
}
