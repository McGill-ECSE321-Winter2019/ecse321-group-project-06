package ca.mcgill.ecse321.cooperator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.repository.CoopTermRepository;
import ca.mcgill.ecse321.cooperator.repository.EmployerRepository;
import ca.mcgill.ecse321.cooperator.repository.EventRepository;
import ca.mcgill.ecse321.cooperator.repository.StudentRepository;
import ca.mcgill.ecse321.cooperator.service.EmployerService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class CooperatorApplicationTests {
	
	@Test
	public void contextLoads() {
	}
	
	/* create mocks for all the services */

	@Mock
	private EmployerRepository employerDao;
	
	@Mock
	private CoopTermRepository coopTermDao;
	
	@Mock
	private EventRepository eventDao;
	
	@Mock
	private StudentRepository studentDao;
	
	/* inject mocks for unit under test */
	@InjectMocks
	private EmployerService employerService;
	
	private Employer employer;
	private static final String SYSTEM_KEY = "testEmployer@gmail.com";
	private static final String NONEXISTING_KEY = "nothing";
	
	@Before
	public void setupMock() {
		employer = mock(Employer.class);
	}
	
	@Before
	public void setMockOutput() {
		when(employerDao.findByEmail(anyString())).thenAnswer( (InvocationOnMock invocation)-> {	
			if (invocation.getArgument(0).equals(SYSTEM_KEY)) {
				Employer employer = new Employer();
				employer.setEmail(SYSTEM_KEY);
				return employer;
			}else {
				return null;
			}
		});
	}
	
	/**
	 * test Mock creation of the employer
	 */
	@Test
	public void testMockEmployerCreation() {
		assertNotNull(employer);
	}

	/**
	 * test query found
	 */
	@Test
	public void testMockEmployerQueryFound() {
		assertNotNull(employerService.getEmployerByEmail(SYSTEM_KEY));
	}
	
}

