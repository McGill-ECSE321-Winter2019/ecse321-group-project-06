package ca.mcgill.ecse321.cooperator.IntegrationTest;


//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import ca.mcgill.ecse321.cooperator.controller.EventController;
import ca.mcgill.ecse321.cooperator.entity.Event;
import ca.mcgill.ecse321.cooperator.repository.EventRepository;
import ca.mcgill.ecse321.cooperator.service.EventService;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureMockMvc

public class EventControllerIntegrationTest {
   // @Autowired
	private MockMvc mvc;
	private Event testEvent;
	private List<Event> testEvents;
	private JacksonTester<List<Event>> jsoneventlist;
	private Date endDate;
	private Date startDate;
	
	@MockBean
	private EventRepository eventRepo;
	@Autowired
	private EventService eventService;
	@Autowired  
	private EventController eventController;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(eventController).build();
		JacksonTester.initFields(this, new ObjectMapper());
		testEvent= new Event();
		testEvent.setEndDate(endDate);
		testEvent.setStartDate(startDate);
		testEvent.setLocation("testLocation");
		//testEvent.set
		testEvents = new ArrayList<>();
		testEvents.add(testEvent);
		}
	
	@After
	public void resetMock() {
		//eventRepo.deleteAll();
		//reset(eventRepo);
		//reset(eventService);
		//reset(eventController);

	}
	@Test
	public void canGetEvents() throws Exception{
		when(eventRepo.findAll()).thenReturn(testEvents);
		MvcResult result = mvc.perform(get("/events"))
				//.andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk())
				.andReturn();
		String objAsJson = jsoneventlist.write(testEvents).getJson();
		String responseContent = result.getResponse().getContentAsString();
		assertEquals(objAsJson,responseContent);
	}
}
