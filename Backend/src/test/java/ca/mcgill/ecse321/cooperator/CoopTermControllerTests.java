package ca.mcgill.ecse321.cooperator;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.controller.CoopTermController;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.CoopTermStates;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Student;
import ca.mcgill.ecse321.cooperator.repository.CoopTermRepository;
import ca.mcgill.ecse321.cooperator.service.CoopTermService;

import org.junit.Before;
import org.junit.After;
import org.junit.Rule;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class CoopTermControllerTests {
	@Mock
	private CoopTermRepository coopTermDao;
	
	@InjectMocks
	private CoopTermService coopTermService;
	
	@InjectMocks
	private CoopTermController coopTermController;
	
	
	private CoopTerm coopTerm;
	private CoopTerm coopTerm1;
	
	private Student student1;
	private Student student2;
	
	private Employer employer1;
	private Employer employer2;
	
	
	@Before
	public void setupMock() {
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.OCTOBER, 16, 9, 00, 0);
 		Date startDate = new Date(c.getTimeInMillis());
		c.set(2016, Calendar.OCTOBER, 16, 9, 30, 0);
		Date endDate = new Date(c.getTimeInMillis());
		
		student1 = new Student();
		student1.setCoopUserId(1);
		
		student2 = new Student();
		student2.setCoopUserId(2);
		
		employer1 = new Employer();
		employer1.setCoopUserId(1);
		
		employer2 = new Employer();
		employer2.setCoopUserId(2);
		
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
		coopTerm.setStudent(student1);
		coopTerm.setEmployer(employer1);
		
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
		coopTerm1.setStudent(student1);
		coopTerm1.setEmployer(employer1);
	}
	
	@Before
	public void setMockOutput() {
		when(coopTermDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		     return coopTerm;
		  });
		
		when(coopTermDao.findByStartDate((java.sql.Date) any(Date.class))).thenAnswer( (InvocationOnMock invocation) -> {
		     return coopTerm;
		  });
		
		when(coopTermDao.findByEndDate((java.sql.Date) any(Date.class))).thenAnswer( (InvocationOnMock invocation) -> {
		     return coopTerm;
		  });
		
		when(coopTermDao.findByLocation(anyString())).thenAnswer( (InvocationOnMock invocation) -> {
		     return coopTerm;
		  });
	
		when(coopTermDao.findByAcademicSemester(anyString())).thenAnswer( (InvocationOnMock invocation) -> {
		     return coopTerm;
		  });
		
		when(coopTermDao.findAll()).thenAnswer( (InvocationOnMock invocation) -> {
			List<CoopTerm> allCoopTerms = new ArrayList<>();
			allCoopTerms.add(coopTerm);
			allCoopTerms.add(coopTerm1);
		    return allCoopTerms;
		  });
	}	
	
	/*test successfully create mock coopTerm */
	@Test
	public void testMockCoopTermCreation() {
		assertNotNull(coopTerm);
	}
	
	/*test successfully get one coopTerm by id return corresponding coopTerm*/
	@Test
	public void testGetCoopTermById() {
		CoopTerm coopTermReturned = coopTermService.getCoopTerm(1);
		assertEquals(1, coopTermReturned.getcoopTermId());
		compare(coopTerm, coopTermReturned);
	}
	
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	/*test get coopTerm returns null should throw exception*/
	@Test 
	public void testGetCoopTermByIdReturnNull() {
		when(coopTermDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		     return null;
		  });
	     try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("Coopterm doesn't exist!");
		coopTermService.getCoopTerm(1);
	}
	

	
	
	/*test successfully update a coopTerm by id returns updated coopTerm*/
	@Test
	public void testUpdateCoopTermStateById() {
		CoopTerm newCoopTerm = coopTerm;
		newCoopTerm.setState(CoopTermStates.ACTIVE);
		newCoopTerm.setEvaluationForm("new evaluation form");
		CoopTerm coopTerm = coopTermService.updateCoopTerm(1, newCoopTerm);
		compare(newCoopTerm, coopTerm);
	}
	
	/*test update a coopTerm returns null throws exception*/
	@Test
	public void testUpdateCoopTermStateByIdReturnNull() {
		when(coopTermDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		     return null;
		  });
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("Coopterm doesn't exist!");
		CoopTerm newCoopTerm = coopTerm;
		newCoopTerm.setState(CoopTermStates.ACTIVE);
		newCoopTerm.setEvaluationForm("new evaluation form");
		coopTermService.updateCoopTerm(1, newCoopTerm);
	}
	
	/*test update a coopTerm by an invalid id input returns null throws exception*/
	@Test
	public void testUpdateCoopTermStateByInvalidIdReturnNull() {
		when(coopTermDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		     return null;
		  });
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("invalid id input!");
		CoopTerm newCoopTerm = coopTerm;
		newCoopTerm.setState(CoopTermStates.ACTIVE);
		newCoopTerm.setEvaluationForm("new evaluation form");
		coopTermService.updateCoopTerm(-1, newCoopTerm);
	}
	
	
	/*test update a coopTerm by an invalid newCoopTerm input returns null throws exception*/
	@Test
	public void testUpdateCoopTermStateByInvalidNewCooptermReturnNull() {
		when(coopTermDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		     return null;
		  });
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("invalid newCoopTerm!");
		CoopTerm newCoopTerm = coopTerm;
		newCoopTerm.setState(CoopTermStates.ACTIVE);
		newCoopTerm.setEvaluationForm("new evaluation form");
		coopTermService.updateCoopTerm(1, null);
	}
	
	
	/*test successfully get all coopTerms return a list of coopTerms*/
	@Test
	public void testGetAllCoopTerms() {
		List<CoopTerm> coopTerms = coopTermService.getAllCoopTerms();
		compare(coopTerm, coopTerms.get(0));
		compare(coopTerm1, coopTerms.get(1));
	}
	
	
	/*test successfully get coopTerms of an student*/
	@Test
	public void testCoopTermsOfAnStudent() {
		List<CoopTerm> coopTerms = coopTermService.getAllCoopTermsOfAnStudent(1);
		compare(coopTerm, coopTerms.get(0));
		compare(coopTerm1, coopTerms.get(1));
	}
	
	/*test get coopTerms of an student returns null throws exception*/
	@Test
	public void testCoopTermsOfAnStudentReturnNull() {
		when(coopTermDao.findAll()).thenAnswer( (InvocationOnMock invocation) -> {
			List<CoopTerm> allCoopTerms = new ArrayList<>();
		     return allCoopTerms;
		  });
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("There is no coop terms for this employer!");
		coopTermService.getAllCoopTermsOfAnStudent(1);	
	}
	
	/*test successfully get coopTerms of an employer*/
	@Test
	public void testCoopTermsOfAnEmployer() {
		List<CoopTerm> coopTerms = coopTermService.getAllCoopTermOfAnEmployer(1);
		compare(coopTerm, coopTerms.get(0));
		compare(coopTerm1, coopTerms.get(1));
	}
	
	/*test get coopTerms of an employer returns null throws exception*/
	@Test
	public void testCoopTermsOfAnEmployerReturnNull() {
		when(coopTermDao.findAll()).thenAnswer( (InvocationOnMock invocation) -> {
			List<CoopTerm> allCoopTerms = new ArrayList<>();
		     return allCoopTerms;
		  });
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("There is no coop terms for this employer!");
		coopTermService.getAllCoopTermOfAnEmployer(1);	
	}
	
	/* method to compare two coopterms */
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
