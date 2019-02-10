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
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.entity.CoopAdmin;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Student;
import ca.mcgill.ecse321.cooperator.repository.CoopTermRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoopTermServiceTest {
	@Autowired
	private CoopTermService coopTermService;
	@Autowired
	private CoopTermRepository coopTermRepository;
	
	@After
	public void clearDatabase() {	
		coopTermRepository.deleteAll();
	}
	
	@Test
	public void testCreateCoopTerm() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());

		String location = "Mcgill";
		Date startDate = new Date(2018,9,01);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Date date = new Date(2020,5,1);
		Student student= new Student("test@gmail.com", "Kevin", "sadaf", 260664930, "Mcgill",date) ;
		Employer employer= new Employer("company@gmail.com","wq","Amazon");
		CoopAdmin coopAdmin=new CoopAdmin ();
		Date endDate = new Date(2022,5,1);

		CoopTerm coopTerm = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, student,  employer,coopAdmin,endDate);
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
		assertEquals(student, coopTerm.getStudent());
		assertEquals(employer, coopTerm.getEmployer());
		assertEquals(coopAdmin, coopTerm.getCoopAdmin());
		assertEquals(endDate, coopTerm.getEndDate());
		
	}
	
	@Test
	public void testCreateCoopTermWithNullLocation() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = null;
		Date startDate = new Date(2018,9,01);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Date date = new Date(2020,5,1);
		Student student= new Student("test@gmail.com", "Kevin", "sadaf", 260664930, "Mcgill",date) ;
		Employer employer= new Employer("company@gmail.com","wq","Amazon");
		CoopAdmin coopAdmin=new CoopAdmin ();
		Date endDate = new Date(2022,5,1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, student,  employer,coopAdmin,endDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("location cannot be empty!", error);

		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithNullStartDate() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = null;
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Date date = new Date(2020,5,1);
		Student student= new Student("test@gmail.com", "Kevin", "sadaf", 260664930, "Mcgill",date) ;
		Employer employer= new Employer("company@gmail.com","wq","Amazon");
		CoopAdmin coopAdmin=new CoopAdmin ();
		Date endDate = new Date(2022,5,1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, student,  employer,coopAdmin,endDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("startDate cannot be empty!", error);

		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithWrongStartDateMonth() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = new Date(2018,13,01);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Date date = new Date(2020,5,1);
		Student student= new Student("test@gmail.com", "Kevin", "sadaf", 260664930, "Mcgill",date) ;
		Employer employer= new Employer("company@gmail.com","wq","Amazon");
		CoopAdmin coopAdmin=new CoopAdmin ();
		Date endDate = new Date(2022,5,1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, student,  employer,coopAdmin,endDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("startDate should have valid month!", error);

		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithWrongStartDateYear() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = new Date(201,13,01);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Date date = new Date(2020,5,1);
		Student student= new Student("test@gmail.com", "Kevin", "sadaf", 260664930, "Mcgill",date) ;
		Employer employer= new Employer("company@gmail.com","wq","Amazon");
		CoopAdmin coopAdmin=new CoopAdmin ();
		Date endDate = new Date(2022,5,1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, student,  employer,coopAdmin,endDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("startDate should have valid year!", error);

		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithNullAcademicSemester() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = new Date(2018,9,01);
		String academicSemester= null;  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Date date = new Date(2020,5,1);
		Student student= new Student("test@gmail.com", "Kevin", "sadaf", 260664930, "Mcgill",date) ;
		Employer employer= new Employer("company@gmail.com","wq","Amazon");
		CoopAdmin coopAdmin=new CoopAdmin ();
		Date endDate = new Date(2022,5,1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, student,  employer,coopAdmin,endDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("academicSemester cannot be empty!", error);

		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithNullJobDescription() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = new Date(2018,9,01);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true ;
		String jobDescription= null;
		Date date = new Date(2020,5,1);
		Student student= new Student("test@gmail.com", "Kevin", "sadaf", 260664930, "Mcgill",date) ;
		Employer employer= new Employer("company@gmail.com","wq","Amazon");
		CoopAdmin coopAdmin=new CoopAdmin ();
		Date endDate = new Date(2022,5,1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, student,  employer,coopAdmin,endDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("jobDescription cannot be empty!", error);

		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithNullStudent() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = new Date(2018,9,01);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true ;
		String jobDescription= "Software Internship";
		Date date = new Date(2020,5,1);
		Student student= null ;
		Employer employer= new Employer("company@gmail.com","wq","Amazon");
		CoopAdmin coopAdmin=new CoopAdmin ();
		Date endDate = new Date(2022,5,1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, student,  employer,coopAdmin,endDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("student cannot be empty!", error);

		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithNullEmployer() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = new Date(2018,9,01);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true ;
		String jobDescription= "Software Internship";
		Date date = new Date(2020,5,1);
		Student student= new Student("test@gmail.com", "Kevin", "sadaf", 260664930, "Mcgill",date) ;
		Employer employer= null;
		CoopAdmin coopAdmin=new CoopAdmin ();
		Date endDate = new Date(2022,5,1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, student,  employer,coopAdmin,endDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("employer cannot be empty!", error);

		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithNullCoopAdmin() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = new Date(2018,9,01);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true ;
		String jobDescription= "Software Internship";
		Date date = new Date(2020,5,1);
		Student student= new Student("test@gmail.com", "Kevin", "sadaf", 260664930, "Mcgill",date) ;
		Employer employer= new Employer("company@gmail.com","wq","Amazon");
		CoopAdmin coopAdmin=null;
		Date endDate = new Date(2022,5,1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, student,  employer,coopAdmin,endDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("coopAdmin cannot be empty!", error);

		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithNullEndDate() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = new Date(2018,9,01);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true ;
		String jobDescription= "Software Internship";
		Date date = new Date(2020,5,1);
		Student student= new Student("test@gmail.com", "Kevin", "sadaf", 260664930, "Mcgill",date) ;
		Employer employer= new Employer("company@gmail.com","wq","Amazon");
		CoopAdmin coopAdmin=new CoopAdmin ();
		Date endDate = null;

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, student,  employer,coopAdmin,endDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("endDate cannot be empty!", error);

		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithWrongEndDateMonth() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = new Date(2018,9,01);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Date date = new Date(2020,5,1);
		Student student= new Student("test@gmail.com", "Kevin", "sadaf", 260664930, "Mcgill",date) ;
		Employer employer= new Employer("company@gmail.com","wq","Amazon");
		CoopAdmin coopAdmin=new CoopAdmin ();
		Date endDate = new Date(2022,13,1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, student,  employer,coopAdmin,endDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("endDate should have valid month!", error);

		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
	
	@Test
	public void testCreateCoopTermWithWrongEndDateYear() {
		assertEquals(0, coopTermService.getAllCoopTerms().size());
		
		String location = "Mcgill";
		Date startDate = new Date(2012,13,01);
		String academicSemester= "fall";  
		boolean ifWorkPermitNeeded= true;
		String jobDescription= "Software Internship";
		Date date = new Date(2020,5,1);
		Student student= new Student("test@gmail.com", "Kevin", "sadaf", 260664930, "Mcgill",date) ;
		Employer employer= new Employer("company@gmail.com","wq","Amazon");
		CoopAdmin coopAdmin=new CoopAdmin ();
		Date endDate = new Date(202,5,1);

		CoopTerm coopTerm = null;
		String error = null;
		try {
			coopTerm = coopTermService.createCoopTerm(location, startDate, academicSemester, ifWorkPermitNeeded,
					jobDescription, student,  employer,coopAdmin,endDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("endDate should have valid year!", error);

		assertEquals(0, coopTermService.getAllCoopTerms().size());
	}
}