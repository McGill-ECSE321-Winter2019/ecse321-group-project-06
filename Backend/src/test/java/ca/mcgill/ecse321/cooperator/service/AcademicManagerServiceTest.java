package ca.mcgill.ecse321.cooperator.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.entity.AcademicManager;
import ca.mcgill.ecse321.cooperator.repository.AcademicManagerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcademicManagerServiceTest {

	@Autowired
	private AcademicManagerService academicManagerService;
	@Autowired
	private AcademicManagerRepository academicManagerRepository;
	
	@After
	public void clearDatabase() {	
		// clear academicmanager to avoid exceptions due to inconsistence
		academicManagerRepository.deleteAll();
	}
	
	@Test
	public void testCreateAcademicManager() {
		assertEquals(0, academicManagerService.getAllAcademicManager().size());

		String email = "test@gmail.com";
		String password = "12345678";
		String name = "testName";

		AcademicManager academicManager= null;
		try {
			academicManager = academicManagerService.createAcademicManager(email, password, name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<AcademicManager> allAcademicManagers = academicManagerService.getAllAcademicManager();

		assertEquals(1, allAcademicManagers.size());
		
		assertEquals(name, academicManager.getName());
		assertEquals(email, academicManager.getEmail());
		assertEquals(password, academicManager.getPassword());
	}
	
	
	@Test
	public void testCreateAcademicManagerWithNullName() {
		assertEquals(0, academicManagerService.getAllAcademicManager().size());
		
		String email = "test@gmail.com";
		String password = "12345678";
		String name = null;

		AcademicManager academicManager= null;
		String error = null;
		try {
			academicManager = academicManagerService.createAcademicManager(email, password, name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("name cannot be empty!", error);

		assertEquals(0, academicManagerService.getAllAcademicManager().size());
	}
	
	@Test
	public void testCreateAcademicManagerWithNullEmail() {
		assertEquals(0, academicManagerService.getAllAcademicManager().size());
		
		String email = null;
		String password = "12345678";
		String name = "test name";

		AcademicManager academicManager = null;
		String error = null;
		try {
			academicManager = academicManagerService.createAcademicManager(email, password, name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("email cannot be empty!", error);

		assertEquals(0, academicManagerService.getAllAcademicManager().size());
	}
	
	@Test
	public void testCreateAcademicManagerWithNullPassword() {
		assertEquals(0, academicManagerService.getAllAcademicManager().size());
		
		String email = "test@gmail.com";
		String password = null;
		String name = "test name";

		AcademicManager academicManager = null;
		String error = null;
		try {
			academicManager = academicManagerService.createAcademicManager(email, password, name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("password cannot be empty!", error);

		assertEquals(0, academicManagerService.getAllAcademicManager().size());
	}


	
}
