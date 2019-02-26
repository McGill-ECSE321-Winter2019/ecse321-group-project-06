package ca.mcgill.ecse321.cooperator;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.controller.StudentController;
import ca.mcgill.ecse321.cooperator.entity.Employer;
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
	private static final String STUDENT_KEY = "TestStudent";
	private static final String NONEXISTING_KEY = "NotAStudent";
	
	@Before
	public void setupMock() {
		student = new Student();
		student.setCoopUserId(1);
		student.setEmail("testStudent@mail.mcgill.ca");
		student.setName(STUDENT_KEY);
		student.setPassword("test password");
	}
	
	@Test
	public void testMockPersonCreation() {
		assertNotNull(student);
	}
	
	@Test
	public void testParticipantQueryFound() {
		when(studentService.getStudent(anyInt())).thenReturn(student);
		assertEquals(STUDENT_KEY, studentService.getStudent(1).getName());
		assertEquals("testStudent@mail.mcgill.ca", studentService.getStudent(1).getEmail());
		assertEquals("test password", studentService.getStudent(1).getPassword());
		
	}
}
	


