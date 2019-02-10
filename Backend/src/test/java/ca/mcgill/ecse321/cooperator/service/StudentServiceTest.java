package ca.mcgill.ecse321.cooperator.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.repository.StudentRepository;
import ca.mcgill.ecse321.cooperator.service.StudentService;
import ca.mcgill.ecse321.cooperator.entity.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {


	@Autowired
	private StudentService service;

	@Autowired 
	private StudentRepository studentRepository;

	@After
	public void clearDatabase() {
		// First, we clear registrations to avoid exceptions due to inconsistencies
		studentRepository.deleteAll();
		// Then we can clear the other tables
	}

	@Test
	public void testCreateStudent() {
		assertEquals(0, service.getAllStudents().size());

		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = "abcdefghi";
		String studentName = "ABC";
		int studentId = 26071190;
		String school = "McGill";
		Calendar graduationMonth = Calendar.getInstance();   
		Calendar graduationYear = Calendar.getInstance();
		graduationMonth.set(Calendar.MONTH, 1);  
		graduationYear.set(Calendar.YEAR, 2001); 

		Student student = null; 

		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationMonth,graduationYear);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Student> allStudents = service.getAllStudents();
		
		assertEquals(1, allStudents.size());
		//assertEquals(userEmail, student.getEmail());
		assertEquals(userPassword, student.getPassword());
		assertEquals(studentName, student.getName());
		assertEquals(studentId, student.getStudentId());
		assertEquals(school, student.getSchool());
		assertEquals(graduationMonth, student.getGraduationMonth());
		assertEquals(graduationYear, student.getGraduationYear());
	}
	
	@Test
	public void testCreateStudentWithNullEmail() {
		assertEquals(0, service.getAllStudents().size());
		
		String userEmail = null;
		String userPassword = "abcdefghi";
		String studentName = "ABC";
		int studentId = 26071190;
		String school = "McGill";
		Calendar graduationMonth = Calendar.getInstance();
		Calendar graduationYear = Calendar.getInstance();          
		graduationMonth.set(Calendar.MONTH, 1);  
		graduationYear.set(Calendar.YEAR, 2001); 
		//graduationDate.set(2020, 12);
		Student student = null; 
		String error = null;
		
		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationMonth,graduationYear);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("Email cannot be empty!", error);
		assertEquals(0, service.getAllStudents().size());		
	}
	
	@Test
	public void testCreateStudentWithNullPassword() {
		assertEquals(0, service.getAllStudents().size());
		
		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = null;
		String studentName = "ABC";
		int studentId = 26071190;
		String school = "McGill";
		Calendar graduationMonth = Calendar.getInstance();
		Calendar graduationYear = Calendar.getInstance();
		//graduationDate.set(2020, 12);            
		graduationMonth.set(Calendar.MONTH, 1);  
		graduationYear.set(Calendar.YEAR, 2001); 
		Student student = null; 
		String error = null;
		
		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationMonth, graduationYear);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("password cannot be empty!", error);
		assertEquals(0, service.getAllStudents().size());		
	}
	
	@Test
	public void testCreateStudentWithNullName() {
		assertEquals(0, service.getAllStudents().size());
		
		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = "abcdefghi";
		String studentName = null;
		int studentId = 26071190;
		String school = "McGill";
		Calendar graduationMonth = Calendar.getInstance();
		Calendar graduationYear = Calendar.getInstance();
		//graduationDate.set(2020, 12);           
		graduationMonth.set(Calendar.MONTH, 1);  
		graduationYear.set(Calendar.YEAR, 2001); 
		Student student = null; 
		String error = null;
		
		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationMonth,graduationYear);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("Student name cannot be empty!", error);
		assertEquals(0, service.getAllStudents().size());		
	}
	
	@Test
	public void testCreateStudentWithInvalidId() {
		assertEquals(0, service.getAllStudents().size());
		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = "abcdefghi";
		String studentName = "ABC";
		int studentId = 1;
		String school = "McGill";
		Calendar graduationMonth = Calendar.getInstance();
		Calendar graduationYear = Calendar.getInstance();
		//graduationDate.set(2020, 12);
		//graduationDate.set(Calendar.YEAR, 0);             
		graduationMonth.set(Calendar.MONTH, 1);  
		graduationYear.set(Calendar.YEAR, 2001); 
		Student student = null; 
		String error = null;
		
		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationMonth, graduationYear);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("Student Id should be more than 1 digit!", error);
		assertEquals(0, service.getAllStudents().size());		
	}
	
	@Test
	public void testCreateStudentWithNullSchool() {
		assertEquals(0, service.getAllStudents().size());
		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = "abcdefghi";
		String studentName = "ABC";
		int studentId = 71190;
		String school = null;
		Calendar graduationMonth = Calendar.getInstance();
		Calendar graduationYear = Calendar.getInstance();
		//graduationDate.set(2020, 12);            
		graduationMonth.set(Calendar.MONTH, 1);  
		graduationYear.set(Calendar.YEAR, 2001); 
		Student student = null; 
		String error = null;
		
		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationMonth, graduationYear);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("school entry cannot be empty!", error);
		assertEquals(0, service.getAllStudents().size());		
	}
	
	@Test
	public void testCreateStudentWithNullMonth() {
		assertEquals(0, service.getAllStudents().size());
		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = "abcdefghi";
		String studentName = "ABC";
		int studentId = 26071190;
		String school = "McGill";
		Calendar graduationMonth = null;   
		Calendar graduationYear = Calendar.getInstance();
		Student student = null; 
		String error = null;
		
		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationMonth,graduationYear);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("Graduation Month cannot be empty!", error);
		assertEquals(0, service.getAllStudents().size());		
	}
	
	@Test
	public void testCreateStudentWithNullYear() {
		assertEquals(0, service.getAllStudents().size());
		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = "abcdefghi";
		String studentName = "ABC";
		int studentId = 26071190;
		String school = "McGill";
		Calendar graduationMonth = Calendar.getInstance();   
		Calendar graduationYear = null;
		Student student = null; 
		String error = null;
		
		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationMonth,graduationYear);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("Graduation Year cannot be empty!", error);
		assertEquals(0, service.getAllStudents().size());		
	}
	
	
	@Test
	public void testCreateStudentWithInvalidYear() {
		assertEquals(0, service.getAllStudents().size());
		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = "abcdefghi";
		String studentName = "ABC";
		int studentId = 71190;
		String school = "McGill";
		Calendar graduationMonth = Calendar.getInstance();   
		Calendar graduationYear = Calendar.getInstance();
		//graduationDate.set(199, 12);
		//graduationDate.set(Calendar.YEAR, 0);             
		graduationMonth.set(Calendar.MONTH, 1);  
		graduationYear.set(Calendar.YEAR, 190); 
		Student student = null; 
		String error = null;
		
		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationMonth,graduationYear);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("graduation date should be a valid year!", error);
		assertEquals(0, service.getAllStudents().size());		
	}
	
	/*
	@Test
	public void testGetStudentWithCorrectId() {
		//create a student first 
		assertEquals(0, service.getAllStudents().size());
		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = "abcdefghi";
		String studentName = "ABC";
		int studentId = 71190;
		String school = "McGill";
		Calendar graduationDate = Calendar.getInstance();
		//graduationDate.set(2020, 12);
		graduationDate.set(Calendar.YEAR, 0);             
		graduationDate.set(Calendar.MONTH, 1);  
		graduationDate.set(Calendar.YEAR, 2001); 
		Student student = null; 
		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}	
		//get Student
		String error = null;
		try {
			student = service.getStudent(studentId); 
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		List<Student> allStudents = service.getAllStudents();
		assertEquals(1, allStudents.size());
		assertEquals(userEmail, student.getEmail());
		assertEquals(userPassword, student.getPassword());
		assertEquals(studentName, student.getName());
		assertEquals(studentId, student.getStudentId());
		assertEquals(school, student.getSchool());
		assertEquals(graduationDate, student.getGraduationDate());
	}
	
	@Test
	public void testGetStudentWithInvalidId() {
		//create employer first 
		testCreateStudent();
		//get Student
		Student student = null; 
		String error = null;
		try {
			student = service.getStudent(0); 
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		assertEquals("Student Id cannot be empty!", error);	
		}
	}
	*/


}


