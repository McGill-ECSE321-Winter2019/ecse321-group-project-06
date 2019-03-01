package ca.mcgill.ecse321.cooperator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertEquals;

import static org.mockito.ArgumentMatchers.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ca.mcgill.ecse321.cooperator.entity.CoopUser;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Event;
import ca.mcgill.ecse321.cooperator.entity.Student;
import ca.mcgill.ecse321.cooperator.repository.CoopTermRepository;
import ca.mcgill.ecse321.cooperator.repository.EmployerRepository;
import ca.mcgill.ecse321.cooperator.repository.EventRepository;
import ca.mcgill.ecse321.cooperator.repository.StudentRepository;
import ca.mcgill.ecse321.cooperator.controller.CoopTermController;
import ca.mcgill.ecse321.cooperator.service.CoopTermService;
import ca.mcgill.ecse321.cooperator.service.EmployerService;
import ca.mcgill.ecse321.cooperator.service.EventService;
import ca.mcgill.ecse321.cooperator.service.StudentService;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest
public class CooperatorApplicationTest {
    //@Autowired
	private MockMvc mvc;
	private Employer testEmployer;
	private Event testEvent;
	private Student testStudent1;
	private Student testStudent2;
	private CoopTerm testCoopTerm1;
	private CoopTerm testCoopTerm2;
	private Date endDate;
	private Date startDate;
	List<CoopTerm> coopTerms = new ArrayList<>();
	List<Student> students = new ArrayList<>();
	private JacksonTester<CoopTerm> jsonct;
	private JacksonTester<List<CoopTerm>> jsonctlist;
	private JacksonTester<Student> student;
	private JacksonTester<List<Student>> jsonstlist;
	
	@MockBean
	private CoopTermRepository coopTermRepo;
	@Autowired
	private CoopTermService coopTermService;
	@Autowired 
	private CoopTermController coopTermController;
	
//	public static class MockSecutiryContext implements SecurityContext {
//		private static final long serialVersionUID = 31204723579235L;
//
//		private Authentication authentication;
//
//		public MockSecutiryContext(Authentication authentication) {
//			this.authentication = authentication;
//		}
//
//		@Override
//		public Authentication getAuthentication() {
//			return this.authentication;
//		}
//
//		@Override
//		public void setAuthentication(Authentication authentication) {
//			this.authentication = authentication;
//		}
//	}
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(coopTermController).build();
		JacksonTester.initFields(this, new ObjectMapper());
		testEmployer = new Employer();
		testEmployer.setEmail("testEmail");
		testEmployer.setName("testEmployer");
		testEmployer.setPassword("testPassword");
		testEmployer.setCoopUserId(1);
		
		testEmployer.setEvent(new ArrayList<>());
		testEmployer.setCoopTerm(new ArrayList<>());
		
		testStudent1 = new Student();
		testStudent1.setCoopUserId(2);
		testStudent1.setName("testStudent1");
		testStudent1.setPassword("testPassword");
		testStudent1.setCoopUserId(2);
		testStudent1.setCoopTerm(new ArrayList<>());
		
		testStudent2 = new Student();
		testStudent2.setCoopUserId(3);
		testStudent2.setName("testStudent2");
		testStudent2.setPassword("testPassword");
		testStudent2.setCoopUserId(3);
		
		testCoopTerm1 = new CoopTerm();
		testCoopTerm1.setAcademicSemester("FALL2018");
		testCoopTerm1.setCoopPlacement("testPlacement");
		testCoopTerm1.setCoopTermId(4);
		testCoopTerm1.setEmployer(testEmployer);
		testCoopTerm1.setEndDate(endDate);
		testCoopTerm1.setEvaluationForm("testEvaluationForm");
		testCoopTerm1.setIfWorkPermitNeeded(false);
		testCoopTerm1.setJobDescription("testJobDescription");
		testCoopTerm1.setLocation("testLocaltion");
		testCoopTerm1.setStartDate(startDate);
		testCoopTerm1.setStudent(testStudent1);
		testCoopTerm1.setTaxCreditForm("testTaxCreditForm");
		testCoopTerm1.setState(null);
		
		testCoopTerm2 = new CoopTerm();
		testCoopTerm2.setAcademicSemester("FALL 2018");
		testCoopTerm2.setCoopPlacement("testPlacement");
		testCoopTerm2.setCoopTermId(5);
		testCoopTerm2.setEmployer(testEmployer);
		testCoopTerm2.setEndDate(endDate);
		testCoopTerm2.setEvaluationForm("testEvaluationForm");
		testCoopTerm2.setIfWorkPermitNeeded(false);
		testCoopTerm2.setJobDescription("testJobDescription");
		testCoopTerm2.setLocation("testLocaltion");
		testCoopTerm2.setStartDate(startDate);
		testCoopTerm2.setStudent(testStudent2);
		testCoopTerm2.setTaxCreditForm("testTaxCreditForm");
		
		coopTerms.add(testCoopTerm1);
		coopTerms.add(testCoopTerm2);
		students.add(testStudent1);
		students.add(testStudent2);
		}
	
	@Test
	public void canGetOneCoopTerm() throws Exception {
		when(coopTermRepo.findById(anyInt())).thenAnswer((InvocationOnMock invocation)->{
			return testCoopTerm1;
		});
		String objAsJson = jsonct.write(testCoopTerm1).getJson();
		MvcResult result = mvc.perform(get("/coopTerm/1/"))
				//.andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andReturn();
		String responseContent = result.getResponse().getContentAsString();
		//assertEquals(coopTermController.getCoopTermById(2),this.testCoopTerm1);
		assertEquals(objAsJson,responseContent);
		//assertEquals(this.testCoopTerm1,result.getResponse());
	}
}
//	@Test
//	public void canGetCoopTerms() throws Exception{
//		when(coopTermRepo.findAllById(anyInt())).thenReturn(coopTerms);
//		MvcResult result = mvc.perform(null)
//				//.andDo(print())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//				.andExpect(status().isOk())
//				.andReturn();
//		String responseContent = result.getResponse().getContentAsString();
//		assertEquals(this.coopTerms,this.coopTerms);
//	}
//
//}
