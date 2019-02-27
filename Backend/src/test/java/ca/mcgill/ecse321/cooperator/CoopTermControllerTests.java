package ca.mcgill.ecse321.cooperator;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.controller.CoopTermController;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.CoopTermStates;
import ca.mcgill.ecse321.cooperator.repository.CoopTermRepository;
import ca.mcgill.ecse321.cooperator.service.CoopTermService;

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

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoopTermControllerTests {
	@Mock
	private CoopTermRepository coopTermDao;
	@InjectMocks
	private CoopTermService coopTermService;
	@InjectMocks
	private CoopTermController coopTermController;
	private CoopTerm coopTerm;
	
	@Before
	public void setupMock() {
		coopTerm = new CoopTerm();
		coopTerm.setCoopTermId(1);
		
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.OCTOBER, 16, 9, 00, 0);
 		Date startDate = new Date(c.getTimeInMillis());
		c.set(2016, Calendar.OCTOBER, 16, 9, 30, 0);
		Date endDate = new Date(c.getTimeInMillis());
		
		coopTerm.setStartDate(startDate);
		coopTerm.setEndDate(endDate);
		coopTerm.setCoopPlacement("coop placement");
		coopTerm.setIfWorkPermitNeeded(true);
		coopTerm.setJobDescription("job description");
		coopTerm.setLocation("Montreal");
		coopTerm.setAcademicSemester("FALL2018");
	}
	
	@Before
	public void setMockOutput() {
		when(coopTermDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		     return coopTerm;
		  });
	}
	
	@Test
	public void testMockCoopTermCreation() {
		assertNotNull(coopTerm);
	}
	
	@Test
	public void testGetCoopTermById() {
		CoopTerm coopTermReturned = coopTermService.getCoopTerm(1);
		assertEquals(1, coopTermReturned.getcoopTermId());
		compare(coopTerm, coopTermReturned);
	}
	
	@Test
	public void testUpdateCoopTermStateById() {
		CoopTerm newCoopTerm = coopTerm;
		newCoopTerm.setState(CoopTermStates.ACTIVE);
		newCoopTerm.setEvaluationForm("evaluation form");
		CoopTerm coopTerm = coopTermService.updateCoopTerm(1, newCoopTerm);
		assertEquals(CoopTermStates.ACTIVE, coopTerm.getState());
		assertEquals("evaluation form", coopTerm.getEvaluationForm());
		compare(newCoopTerm, coopTerm);
	}
	
	private void compare(CoopTerm coopTermExpected, CoopTerm coopTermReturned) {
		assertEquals(coopTermExpected.getAcademicSemester(), coopTermReturned.getAcademicSemester());
		assertEquals(coopTermExpected.getCoopPlacement(), coopTermReturned.getCoopPlacement());
		assertEquals(coopTermExpected.getStartDate(), coopTermReturned.getStartDate());
		assertEquals(coopTermExpected.getEndDate(), coopTermReturned.getEndDate());
		assertEquals(coopTermExpected.getJobDescription(), coopTermReturned.getJobDescription());
		assertEquals(coopTermExpected.getLocation(), coopTermReturned.getLocation());
		assertEquals(coopTermExpected.isIfWorkPermitNeeded(), coopTermReturned.isIfWorkPermitNeeded());
	}
}
