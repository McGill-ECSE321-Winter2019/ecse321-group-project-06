package ca.mcgill.ecse321.cooperator;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.controller.StudentController;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
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
	
	@Test
	public void testMockPersonCreation() {
		assertNotNull(student);
		assertNotNull(student1);
	}
	
	/*Test getStudent in StudentService class with valid input*/
	@SuppressWarnings("deprecation")
	@Test
	public void testGetStudentFindById() {
		when(studentDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		     return student;
		});
		assertEquals(STUDENT_KEY, studentService.getStudent(1).getName());
		assertEquals("testStudent@mail.mcgill.ca", studentService.getStudent(1).getEmail());
		assertEquals("test password", studentService.getStudent(1).getPassword());
		assertEquals("testSchool", studentService.getStudent(1).getSchool());
		assertEquals(2020, studentService.getStudent(1).getGraduationDate().getYear());
		assertEquals(10, studentService.getStudent(1).getGraduationDate().getMonth());
	}
	
	@Rule 
	public ExpectedException exceptionRule = ExpectedException.none();
	
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
	
	/*All student tests*/
	@SuppressWarnings("deprecation")
	@Test
	public void testGetAllStudent() {
		when(studentService.getAllStudents()).thenAnswer((InvocationOnMock invocation) -> {
			return studentList;
		});
		assertEquals(STUDENT_KEY, studentService.getAllStudents().get(0).getName());
		assertEquals("testStudent@mail.mcgill.ca", studentService.getAllStudents().get(0).getEmail());
		assertEquals("test password", studentService.getAllStudents().get(0).getPassword());
		assertEquals("testSchool", studentService.getAllStudents().get(0).getSchool());
		assertEquals(2020, studentService.getAllStudents().get(0).getGraduationDate().getYear());
		assertEquals(10, studentService.getAllStudents().get(0).getGraduationDate().getMonth());
		
		assertEquals(STUDENT1_KEY, studentService.getAllStudents().get(1).getName());
		assertEquals("testStudent1@mail.mcgill.ca", studentService.getAllStudents().get(1).getEmail());
		assertEquals("test password1", studentService.getAllStudents().get(1).getPassword());	
		assertEquals("testSchool1", studentService.getAllStudents().get(1).getSchool());
		assertEquals(2019, studentService.getAllStudents().get(1).getGraduationDate().getYear());
		assertEquals(2, studentService.getAllStudents().get(1).getGraduationDate().getMonth());
	}
	
	
	
	
	
	
}
	


