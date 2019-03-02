package ca.mcgill.ecse321.cooperator;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.controller.EmployerController;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.repository.EmployerRepository;
import ca.mcgill.ecse321.cooperator.service.EmployerService;

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

import org.aspectj.lang.annotation.After;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class EmployerControllerTests {
	@Mock
	private EmployerRepository employerDao;
	
	@Mock
	private EmployerService employerService;
	
	@InjectMocks
	private EmployerController employerController;
	
	private Employer employer;
	private static final String EMPLOYER_KEY = "TestEmployer";
	
	
	@Before
	public void setupMock() {
		employer = new Employer();
		employer.setCoopUserId(1);
		employer.setEmail("testEmployer@gmail.com");
		employer.setName(EMPLOYER_KEY);
		employer.setPassword("test password");
	}

	@Test
	public void testMockPersonCreation() {
		assertNotNull(employer);
	}

	@Test
	public void testParticipantQueryFound() {
		when(employerService.getEmployer(anyInt())).thenReturn(employer);
		assertEquals(EMPLOYER_KEY, employerService.getEmployer(1).getName());
	}
}
