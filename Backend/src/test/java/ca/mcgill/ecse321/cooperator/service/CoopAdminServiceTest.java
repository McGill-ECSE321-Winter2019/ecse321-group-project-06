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

import ca.mcgill.ecse321.cooperator.entity.CoopAdmin;
import ca.mcgill.ecse321.cooperator.repository.CoopAdminRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoopAdminServiceTest {
	@Autowired
	private CoopAdminService coopAdminService;
	@Autowired
	private CoopAdminRepository coopAdminRepository;
	
	@After
	public void clearDatabase() {	
		coopAdminRepository.deleteAll();
	}
	
	@Test
	public void testCreateCoopAdmin() {
		assertEquals(0, coopAdminService.getAllCoopAdmins().size());

		String email = "test@gmail.com";
		String password = "12345678";
		String name = "testName";

		CoopAdmin coopAdmin = null;
		try {
			coopAdmin = coopAdminService.createCoopAdmin(email, password, name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<CoopAdmin> allCoopAdmins = coopAdminService.getAllCoopAdmins();

		assertEquals(1, allCoopAdmins.size());
		
		assertEquals(name, coopAdmin.getName());
		assertEquals(email, coopAdmin.getEmail());
		assertEquals(password, coopAdmin.getPassword());
	}
	
	@Test
	public void testCreateCoopAdminWithNullName() {
		assertEquals(0, coopAdminService.getAllCoopAdmins().size());
		
		String email = "test@gmail.com";
		String password = "12345678";
		String name = null;

		CoopAdmin coopAdmin = null;
		String error = null;
		try {
			coopAdmin = coopAdminService.createCoopAdmin(email, password, name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("name cannot be empty!", error);

		assertEquals(0, coopAdminService.getAllCoopAdmins().size());
	}
	
	@Test
	public void testCreateCoopAdminWithNullEmail() {
		assertEquals(0, coopAdminService.getAllCoopAdmins().size());
		
		String email = null;
		String password = "12345678";
		String name = "test name";

		CoopAdmin coopAdmin = null;
		String error = null;
		try {
			coopAdmin = coopAdminService.createCoopAdmin(email, password, name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("email cannot be empty!", error);

		assertEquals(0, coopAdminService.getAllCoopAdmins().size());
	}
	
	@Test
	public void testCreateCoopAdminWithNullPassword() {
		assertEquals(0, coopAdminService.getAllCoopAdmins().size());
		
		String email = "test@gmail.com";
		String password = null;
		String name = "test name";

		CoopAdmin coopAdmin = null;
		String error = null;
		try {
			coopAdmin = coopAdminService.createCoopAdmin(email, password, name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("password cannot be empty!", error);

		assertEquals(0, coopAdminService.getAllCoopAdmins().size());
	}
}
