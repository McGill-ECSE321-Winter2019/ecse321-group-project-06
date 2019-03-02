package ca.mcgill.ecse321.cooperator.IntegrationTest;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.mcgill.ecse321.cooperator.controller.EmployerController;
import ca.mcgill.ecse321.cooperator.dto.EmployerDto;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Event;
import ca.mcgill.ecse321.cooperator.entity.Student;
import ca.mcgill.ecse321.cooperator.repository.EmployerRepository;
import ca.mcgill.ecse321.cooperator.service.EmployerService;
@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureMockMvc
public class EmployerControllerIntegrationTest {

	private Employer testEmployer;
	private Event testEvent;
	private Student testStudent1;
	private Student testStudent2;
	private CoopTerm testCoopTerm1;
	private CoopTerm testCoopTerm2;
	private Date endDate;
	private Date startDate;
	private String testPassword="testPassword";
	private String testEmail="testEmail";
	List<CoopTerm> coopTerms = new ArrayList<>();
	List<Student> students = new ArrayList<>();
	List<Employer> employers = new ArrayList<>();
	private EmployerDto employerDto;
	private JacksonTester<Employer> jsonem;
	private JacksonTester<EmployerDto> jsonemdto;
	//private JacksonTester<List<Student>> jsonstlist;
	
	@MockBean
	private EmployerRepository employerRepo;
	@Autowired
	private EmployerService employerService;
	@Autowired
	private EmployerController employerController;
	//@Autowired
	private MockMvc mvc;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(employerController).build();
		JacksonTester.initFields(this, new ObjectMapper());
		employerDto =new EmployerDto(testEmail , testPassword, "testEmployer", 1);
		testEmployer = new Employer();
		testEmployer.setEmail(testEmail);
		testEmployer.setName("testEmployer");
		testEmployer.setPassword(testPassword);
		testEmployer.setCoopUserId(1);
		
		testEmployer.setEvent(new ArrayList<>());
		testEmployer.setCoopTerm(new ArrayList<>());
		employers.add(testEmployer);
		}
	
	@After
	public void resetMock() {
		employerRepo.deleteAll();
		//reset(employerRepo);
		//reset(employerService);
		//reset(employerController);
	}
	
	@Test
	public void signUpEmployer() throws Exception {
		//String objAsJson = jsonem.write(testEmployer).getJson();
		when(employerRepo.save(anyObject())).thenAnswer((InvocationOnMock invocation)->{
			return testEmployer;
		});
		String objAsJson_dto = jsonemdto.write(employerDto).getJson();
		MvcResult result = mvc.perform(post("/employers/")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objAsJson_dto))
				//.andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andReturn();

		String responseContent = result.getResponse().getContentAsString();
		assertEquals(objAsJson_dto,responseContent);
		//assertEquals(this.testCoopTerm1,result.getResponse());
	}
	@Test
	public void canGetOneEmployer() throws Exception {
		when(employerRepo.findAll()).thenAnswer((InvocationOnMock invocation)->{
			return employers;
		});
		String objAsJson_em = jsonem.write(testEmployer).getJson();
		MvcResult result = mvc.perform(get("/login/")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
//				.content(objAsJson_email)
//				.content(objAsJson_ps)
				.param("Email", testEmail)
				.param("Password",testPassword)
				)
				//.andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andReturn();
		String responseContent = result.getResponse().getContentAsString();
		assertEquals(objAsJson_em,responseContent);
		//employerController.login(testEmail, testPassword)
	}
}
