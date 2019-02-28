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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoopTermControllerTests {
	@Mock
	private CoopTermRepository coopTermDao;
	@InjectMocks
	private CoopTermService coopTermService;
	
	private CoopTerm coopTerm;
	private CoopTerm coopTerm1;
	
	@Before
	public void setupMock() {
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.OCTOBER, 16, 9, 00, 0);
 		Date startDate = new Date(c.getTimeInMillis());
		c.set(2016, Calendar.OCTOBER, 16, 9, 30, 0);
		Date endDate = new Date(c.getTimeInMillis());
		
		coopTerm = new CoopTerm();
		coopTerm.setCoopTermId(1);
		coopTerm.setStartDate(startDate);
		coopTerm.setEndDate(endDate);
		coopTerm.setCoopPlacement("coop placement");
		coopTerm.setTaxCreditForm("tax credit form");
		coopTerm.setEvaluationForm("evaluation form");
		coopTerm.setIfWorkPermitNeeded(true);
		coopTerm.setJobDescription("job description");
		coopTerm.setLocation("Montreal");
		coopTerm.setAcademicSemester("FALL2018");
		coopTerm.setState(CoopTermStates.INACTIVE);
		
		coopTerm1 = new CoopTerm();
		coopTerm1.setCoopTermId(2);
		coopTerm1.setStartDate(startDate);
		coopTerm1.setEndDate(endDate);
		coopTerm1.setCoopPlacement("coop placement1");
		coopTerm1.setTaxCreditForm("tax credit form1");
		coopTerm1.setEvaluationForm("evaluation form1");
		coopTerm1.setIfWorkPermitNeeded(true);
		coopTerm1.setJobDescription("job description1");
		coopTerm1.setLocation("Toronto");
		coopTerm1.setAcademicSemester("WINTER2018");
		coopTerm1.setState(CoopTermStates.ACTIVE);
	}
	
	@Before
	public void setMockOutput() {
		when(coopTermDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		     return coopTerm;
		  });
		when(coopTermDao.findAll()).thenAnswer( (InvocationOnMock invocation) -> {
			List<CoopTerm> allCoopTerms = new ArrayList<>();
			allCoopTerms.add(coopTerm);
			allCoopTerms.add(coopTerm1);
		     return allCoopTerms;
		  });
	}
	
	@Test
	public void testMockCoopTermCreation() {
		assertNotNull(coopTerm);
	}
	
	/*test get one coopTerm by id return corresponding coopTerm*/
	@Test
	public void testGetCoopTermById() {
		CoopTerm coopTermReturned = coopTermService.getCoopTerm(1);
		assertEquals(1, coopTermReturned.getcoopTermId());
		compare(coopTerm, coopTermReturned);
	}
	
	/*test update a coopTerm by id returns updated coopTerm*/
	@Test
	public void testUpdateCoopTermStateById() {
		CoopTerm newCoopTerm = coopTerm;
		newCoopTerm.setState(CoopTermStates.ACTIVE);
		newCoopTerm.setEvaluationForm("new evaluation form");
		CoopTerm coopTerm = coopTermService.updateCoopTerm(1, newCoopTerm);
		compare(newCoopTerm, coopTerm);
	}
	
	/*test get all coopTerms return a list of coopTerms*/
	@Test
	public void testGetAllCoopTerms() {
		List<CoopTerm> coopTerms = coopTermService.getAllCoopTerms();
		compare(coopTerm, coopTerms.get(0));
		compare(coopTerm1, coopTerms.get(1));
	}
	
	private void compare(CoopTerm coopTermExpected, CoopTerm coopTermReturned) {
		assertEquals(coopTermExpected.getAcademicSemester(), coopTermReturned.getAcademicSemester());
		assertEquals(coopTermExpected.getCoopPlacement(), coopTermReturned.getCoopPlacement());
		assertEquals(coopTermExpected.getStartDate(), coopTermReturned.getStartDate());
		assertEquals(coopTermExpected.getEndDate(), coopTermReturned.getEndDate());
		assertEquals(coopTermExpected.getJobDescription(), coopTermReturned.getJobDescription());
		assertEquals(coopTermExpected.getLocation(), coopTermReturned.getLocation());
		assertEquals(coopTermExpected.isIfWorkPermitNeeded(), coopTermReturned.isIfWorkPermitNeeded());
		assertEquals(coopTermExpected.getState(), coopTermReturned.getState());
		assertEquals(coopTermExpected.getcoopTermId(), coopTermReturned.getcoopTermId());
		assertEquals(coopTermExpected.getTaxCreditForm(), coopTermReturned.getTaxCreditForm());
		assertEquals(coopTermExpected.getEvaluationForm(), coopTermReturned.getEvaluationForm());
	}
}
