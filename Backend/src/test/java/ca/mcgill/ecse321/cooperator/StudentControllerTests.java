package ca.mcgill.ecse321.cooperator;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.controller.StudentController;
import ca.mcgill.ecse321.cooperator.entity.Student;
import ca.mcgill.ecse321.cooperator.repository.StudentRepository;
import ca.mcgill.ecse321.cooperator.service.StudentService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTests {
	@Mock
	private StudentRepository studentDao;
	
	@Mock
	private StudentService studentService;
	
	@InjectMocks
	private StudentController studentController;
	
	private Student student;
	private Student student1;
	private List<Student> studentList;
	private static final String STUDENT_KEY = "TestStudent";
	private static final String STUDENT1_KEY = "TestStudent1";
	
	
	
	@Before
	public void setupMock() {
		student = new Student();
		student.setCoopUserId(1);
		student.setEmail("testStudent@mail.mcgill.ca");
		student.setName(STUDENT_KEY);
		student.setPassword("test password");
		
		student1 = new Student();
		student1.setCoopUserId(2);
		student1.setEmail("testStudent1@mail.mcgill.ca");
		student1.setName(STUDENT1_KEY);
		student1.setPassword("test password1");
		
		studentList.add(student);
		studentList.add(student1);
	}
	
	@Test
	public void testMockPersonCreation() {
		assertNotNull(student);
		assertNotNull(student1);
	}
	
	@Test
	public void testParticipantQueryFound() {
		when(studentDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		     return student;
		});
		assertEquals(STUDENT_KEY, studentService.getStudent(1).getName());
		assertEquals("testStudent@mail.mcgill.ca", studentService.getStudent(1).getEmail());
		assertEquals("test password", studentService.getStudent(1).getPassword());
		
	}
	
	/**/
	@Test
	public void testAllParticipantQueryFound() {
		when(studentService.getAllStudents()).thenAnswer((InvocationOnMock invocation) -> {
			return studentList;
		});
		assertEquals(STUDENT_KEY, studentService.getAllStudents().get(0).getName());
		assertEquals("testStudent1@mail.mcgill.ca", studentService.getAllStudents().get(0).getEmail());
		assertEquals("test password", studentService.getAllStudents().get(0).getPassword());
		
		assertEquals(STUDENT1_KEY, studentService.getAllStudents().get(1).getName());
		assertEquals("testStudent1@mail.mcgill.ca", studentService.getAllStudents().get(1).getEmail());
		assertEquals("test password1", studentService.getAllStudents().get(1).getPassword());	
	}
}
	


