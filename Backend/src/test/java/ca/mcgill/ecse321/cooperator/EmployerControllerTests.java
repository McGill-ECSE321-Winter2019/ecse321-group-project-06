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
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.invocation.InvocationOnMock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.After;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class EmployerControllerTests {
	@Mock
	private EmployerRepository employerDao;
	
	@InjectMocks
	private EmployerService employerService;
	
	@InjectMocks
	private EmployerController employerController;
	
	private Employer employer;
	private Employer employer1;
	
	
	@Before
	public void setupMock() {
		employer = new Employer();
		employer.setCoopUserId(123);
		employer.setEmail("testEmployer@gmail.com");
		employer.setName("TestEmployer");
		employer.setPassword("test password");
		
		employer1 = new Employer();
		employer1.setCoopUserId(223);
		employer1.setEmail("testEmployer1@gmail.com");
		employer1.setName("TestEmployer1");
		employer1.setPassword("test password1");
	}

	
	@Before
	public void setMockOutput() {
		when(employerDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation)-> {	
			return employer;
		});
		when(employerDao.findByEmail(anyString())).thenAnswer( (InvocationOnMock invocation)-> {
			return employer;
		});
		when(employerDao.findAll()).thenAnswer( (InvocationOnMock invocation) -> {
			List<Employer> allEmployers = new ArrayList<>();
			allEmployers.add(employer);
			allEmployers.add(employer1);
		    return allEmployers;
		});
		when(employerDao.save(any(Employer.class))).thenAnswer( (InvocationOnMock invocation)-> {	
			return employer;
		});
	}
	
	
	/* test successfully create employer*/
	@Test
	public void testMockEmployerCreation() {
		assertNotNull(employer);
		assertNotNull(employer1);
	}

	/* test get Employer by id return corresponding employer */
	@Test
	public void testGetEmployerByID() {
		Employer employerReturn = employerService.getEmployerById(123);
		assertNotNull(employerReturn);
		assertEquals(123, employerReturn.getCoopUserId());	
		compare(employer,employerReturn);
	}
	
	/* test get Employer by email return corresponding employer */
	@Test
	public void testGetEmployerByEmail() {
		Employer employerReturn = employerService.getEmployerByEmail("testEmployer@gmail.com");
		assertNotNull(employerReturn);
		assertEquals("testEmployer@gmail.com", employerReturn.getEmail());	
		compare(employer,employerReturn);
	}
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	
	/*test get Employer by id returns null should throw exception*/
	@Test 
	public void testGetEmployerByIdReturnNull() {
		when(employerDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		     return null;
		  });
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("there is no such employer");
		employerService.getEmployerById(123);
	}
	

	
	/*test get Employer by invalid id should throw exception*/
	@Test 
	public void testGetEmployerByInvalidId() {
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("invalid id");
		employerService.getEmployerById(-1);
	}
	
	
	/*test get Employer by email returns null should throw exception*/
	@Test 
	public void testGetEmployerByEmailReturnNull() {
		when(employerDao.findByEmail(anyString())).thenAnswer( (InvocationOnMock invocation) -> {
		     return null;
		  });
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("there is no such employer");
		employerService.getEmployerByEmail("testEmployer@gmail.com");
	}
	
	
	/*test get Employer by null email should throw exception*/
	@Test 
	public void testGetEmployerByNullEmail() {
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("email cannot be empty!");
		employerService.getEmployerByEmail(null);
	}
	
	
	/*test get Employer by invalid email should throw exception*/
	@Test 
	public void testGetEmployerByInvalidEmail() {
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("invalid email");
		employerService.getEmployerByEmail("f");
	}
	
	/*test get all employers*/
	@Test
	public void testGetAllEmployer() {
		List<Employer> employerReturn = employerService.getAllEmployers();
		assertNotNull(employerReturn);
		compare(employer, employerReturn.get(0));
		compare(employer1, employerReturn.get(1));	
	}
	
	/* test successfully create employer return corresponding employer */
	@Test
	public void testCreateEmployer() {
		Employer employerReturn = employerService.createEmployer("testEmployer@gmail.com","test password","TestEmployer");
		assertNotNull(employerReturn);	
		compare(employer,employerReturn);
	}

	/* test create employer when email is null */
	@Test
	public void testCreateEmployerEmailNull() {
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("Email cannot be empty!");
		employerService.createEmployer(null,"test password","TestEmployer");	
	}
	
	/* test create employer when email is all space */
	@Test
	public void testCreateEmployerEmailSpace() {
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("Email cannot be empty!");
		employerService.createEmployer("    ","test password","TestEmployer");	
	}
	
	/* test create employer when password is null */
	@Test
	public void testCreateEmployerPasswordNull() {
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("Password cannot be empty!");
		employerService.createEmployer("testEmployer@gmail.com",null,"TestEmployer");	
	}
	
	/* test create employer when password is all space */
	@Test
	public void testCreateEmployerPasswordSpace() {
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("Password cannot be empty!");
		employerService.createEmployer("testEmployer@gmail.com","    ","TestEmployer");	
	}
	
	/* test create employer when Company Name is null */
	@Test
	public void testCreateEmployerCompanyNameNull() {
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("Company name cannot be empty!");
		employerService.createEmployer("testEmployer@gmail.com","test password",null);	
	}
	
	
	/* test create employer when Company Name is all space */
	@Test
	public void testCreateEmployerCompanyNameSpace() {
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("Company name cannot be empty!");
		employerService.createEmployer("testEmployer@gmail.com","test password","    ");	
	}
	
	/* method to compare two employer */
	private void compare(Employer employerExpected, Employer employerReturned) {
		assertEquals(employerExpected.getCoopUserId(), employerReturned.getCoopUserId());
		assertEquals(employerExpected.getEmail(), employerReturned.getEmail());
		assertEquals(employerExpected.getName(), employerReturned.getName());
		assertEquals(employerExpected.getPassword(), employerReturned.getPassword());
	}
	
	
	
}
