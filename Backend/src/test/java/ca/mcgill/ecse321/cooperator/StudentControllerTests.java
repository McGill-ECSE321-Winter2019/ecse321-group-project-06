package ca.mcgill.ecse321.cooperator;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.controller.StudentController;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Event;
import ca.mcgill.ecse321.cooperator.entity.Student;
import ca.mcgill.ecse321.cooperator.repository.StudentRepository;
import ca.mcgill.ecse321.cooperator.service.StudentService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentControllerTests {
	@Mock
	private StudentRepository studentDao;
	
	@InjectMocks
	private StudentService studentService;
	
	@InjectMocks
	private StudentController studentController;
	
	private Student student;
	private Student student1;
	private List<Student> studentList;
	private List<CoopTerm> coopTerm;
	private static final String STUDENT_KEY = "TestStudent";
	private static final String STUDENT1_KEY = "TestStudent1";
	
	
	@SuppressWarnings("deprecation")
	@Before
	public void setupMock() {
		studentList = new ArrayList();
		coopTerm = new ArrayList();
		student = new Student();
		student.setCoopUserId(1);
		student.setEmail("testStudent@mail.mcgill.ca");
		student.setName(STUDENT_KEY);
		student.setPassword("test password");
		student.setSchool("testSchool");
		Date date = new Date();
		date.setYear(2020);
		date.setMonth(10);
		student.setGraduationDate(date);
		student.setCoopTerm(coopTerm);
		
		student1 = new Student();
		student1.setCoopUserId(2);
		student1.setEmail("testStudent1@mail.mcgill.ca");
		student1.setName(STUDENT1_KEY);
		student1.setPassword("test password1");
		student1.setSchool("testSchool1");
		Date date1 = new Date();
		date1.setYear(2019);
		date1.setMonth(2);
		student1.setGraduationDate(date1);
		student1.setCoopTerm(coopTerm);
		
		studentList.add(student);
		studentList.add(student1);
	}
	@Before
	public void setMockOutput() {
		when(studentDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		     return student;
		});
		
		when(studentService.getAllStudents()).thenAnswer((InvocationOnMock invocation) -> {
			studentList.add(student);
			studentList.add(student1);
			return studentList;
		});
		
	}
	
	/*test successfully create mock students */
	@Test
	public void testMockPersonCreation() {
		assertNotNull(student);
		assertNotNull(student1);
	}

	
	/* test successfully get student by id*/
	@Test
	public void testGetStudentFindById() {
		Student studentReturn = studentService.getStudent(1);
		assertNotNull(studentReturn);
		assertEquals(1, studentReturn.getCoopUserId());
		compare(student, studentReturn);	
	}
	
	@Rule 
	public ExpectedException exceptionRule = ExpectedException.none();

	
	/*test get student by id should return null throw exception*/
	@Test
	public void GetStudentByIdReturnNull() {
		when(studentDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		     return null;
		  });
	     try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("Student cannot found!");
		studentService.getStudent(9);
	}
	
	
	
	
	
	/*test null case of getStudentById*/
	@Test
	public void testGetStudentByIdReturnNull() {
		when(studentDao.findById(anyInt())).thenAnswer((InvocationOnMock invocation) -> {
			return null;
		});
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("Student cannot found!");
		studentService.getStudent(1);
	}
	
	/* test successfully get all students */
	@Test
	public void testGetAllStudent() {
		List<Student> studentReturn = studentService.getAllStudents();
		assertNotNull(studentReturn);
		compare(student, studentReturn.get(0));
		compare(student1, studentReturn.get(1));
	}
	
	/* method to compare two students */
	private void compare(Student studentExpected, Student studentReturned) {
		assertEquals(studentExpected.getCoopUserId(), studentReturned.getCoopUserId());
		assertEquals(studentExpected.getCoopTerm(), studentReturned.getCoopTerm());
		assertEquals(studentExpected.getEmail(), studentReturned.getEmail());
		assertEquals(studentExpected.getGraduationDate(), studentReturned.getGraduationDate());
		assertEquals(studentExpected.getName(), studentReturned.getName());
		assertEquals(studentExpected.getPassword(), studentReturned.getPassword());
		assertEquals(studentExpected.getSchool(), studentReturned.getSchool());
	}
	
	
}
	


