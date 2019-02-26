package ca.mcgill.ecse321.cooperator;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.controller.CoopTermController;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
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
		assertEquals(1, coopTermService.getCoopTerm(1).getcoopTermId());
	}
	
}
