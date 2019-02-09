package ca.mcgill.ecse321.persistenceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.repository.EmployerRepository;
import ca.mcgill.ecse321.cooperator.service.EmployerService;
import ca.mcgill.ecse321.cooperator.entity.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployerPersistenceTest {
	
	@Autowired
	private EmployerService service;
	
	@Autowired 
	private EmployerRepository employerRepository;
	
		@After
		public void clearDatabase() {
			// First, we clear registrations to avoid exceptions due to inconsistencies
			employerRepository.deleteAll();
			// Then we can clear the other tables
		}
		
		@Test
		public void testCreateEmployer() {
			assertEquals(0, service.getAllEmployers().size());

			String userEmail = "sam.smith@mail.mcgill.ca";
			String userPassword = "abcdefghi";
			String companyName = "ABC";

			try {
				service.createEmployer(userEmail, userPassword,companyName);
			} catch (IllegalArgumentException e) {
				// Check that no error occurred
				fail();
			}

			List<Employer> allEmployers = service.getAllEmployers();
			Employer employer = null;

			assertEquals(1, allEmployers.size());
			
			assertEquals(userEmail, employer.getEmail());
			assertEquals(userPassword, employer.getPassword());
			assertEquals(companyName, employer.getCompanyName());
			
		}

}
