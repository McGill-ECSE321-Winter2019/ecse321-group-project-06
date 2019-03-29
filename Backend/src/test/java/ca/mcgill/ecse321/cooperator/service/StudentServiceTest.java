package ca.mcgill.ecse321.cooperator.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.repository.StudentRepository;
import ca.mcgill.ecse321.cooperator.service.StudentService;
import ca.mcgill.ecse321.cooperator.entity.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
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

	/* Test creating student, should return no error */
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateStudent() {
		assertEquals(0, service.getAllStudents().size());

		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = "abcdefghi";
		String studentName = "ABC";
		int studentId = 26071190;
		String school = "McGill";
		Date graduationDate = new Date(); 
		graduationDate.setYear(2020);
		graduationDate.setMonth(12);

		Student student = null; 

		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Student> allStudents = service.getAllStudents();

		assertEquals(userEmail, allStudents.get(0).getEmail());
		assertEquals(userPassword, allStudents.get(0).getPassword());
		assertEquals(studentName, allStudents.get(0).getName());
		assertEquals(1, allStudents.size());
		assertEquals(school, allStudents.get(0).getSchool());
		assertEquals(graduationDate, allStudents.get(0).getGraduationDate());
	}

	/* Test creating student with no email provided, should throw exception */
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateStudentWithNullEmail() {
		assertEquals(0, service.getAllStudents().size());

		String userEmail = null;
		String userPassword = "abcdefghi";
		String studentName = "ABC";
		int studentId = 26071190;
		String school = "McGill";
		Date graduationDate = new Date(); 
		graduationDate.setYear(2020);
		graduationDate.setMonth(11);
		Student student = null; 
		String error = null;

		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("Email cannot be empty!", error);
		assertEquals(0, service.getAllStudents().size());		
	}

	/* Test creating student with no user password provided, should throw exception */
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateStudentWithNullPassword() {
		assertEquals(0, service.getAllStudents().size());

		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = null;
		String studentName = "ABC";
		int studentId = 26071190;
		String school = "McGill";
		Date graduationDate = new Date(); 
		graduationDate.setYear(2020);
		graduationDate.setMonth(11);
		Student student = null; 
		String error = null;

		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("password cannot be empty!", error);
		assertEquals(0, service.getAllStudents().size());		
	}

	/* Test creating student with no name provided, should throw exception */
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateStudentWithNullName() {
		assertEquals(0, service.getAllStudents().size());

		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = "abcdefghi";
		String studentName = null;
		int studentId = 26071190;
		String school = "McGill";
		Date graduationDate = new Date(); 
		graduationDate.setYear(2020);
		graduationDate.setMonth(11);
		Student student = null; 
		String error = null;

		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("Student name cannot be empty!", error);
		assertEquals(0, service.getAllStudents().size());		
	}

	/* Test creating student with no school provided, should throw exception */
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateStudentWithNullSchool() {
		assertEquals(0, service.getAllStudents().size());
		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = "abcdefghi";
		String studentName = "ABC";
		int studentId = 71190;
		String school = null;
		Date graduationDate = new Date(); 
		graduationDate.setYear(2020);
		graduationDate.setMonth(11);
		Student student = null; 
		String error = null;

		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("school entry cannot be empty!", error);
		assertEquals(0, service.getAllStudents().size());		
	}

	/* Test creating student with no graduation date provided, should throw exception */
	@Test
	public void testCreateStudentWithNullDate() {
		assertEquals(0, service.getAllStudents().size());
		String userEmail = "sam.smith@mail.mcgill.ca";
		String userPassword = "abcdefghi";
		String studentName = "ABC";
		int studentId = 26071190;
		String school = "McGill";
		Date graduationDate = null;
		Student student = null; 
		String error = null;

		try {
			student = service.createStudent(userEmail,userPassword,studentName,studentId,school,graduationDate);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("Graduation Month cannot be empty!", error);
		assertEquals(0, service.getAllStudents().size());		
	}


}