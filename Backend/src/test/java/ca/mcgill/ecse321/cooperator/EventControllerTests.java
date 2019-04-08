package ca.mcgill.ecse321.cooperator;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.controller.EventController;
import ca.mcgill.ecse321.cooperator.entity.Event;
import ca.mcgill.ecse321.cooperator.repository.EventRepository;
import ca.mcgill.ecse321.cooperator.service.EventService;

import org.junit.Before;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyZeroInteractions;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class EventControllerTests {
	@Mock
	private EventRepository eventDao;
	
	@InjectMocks
	private EventService eventService;
	
	@InjectMocks
	private EventController eventController;
	
	private Event event;
	private Event event1;
	
	@Before
	public void setupMock() {
		Calendar c = Calendar.getInstance();
		String location = "Montreal";
		c.set(2016, Calendar.OCTOBER, 16, 9, 00, 0);
 		Date startdate = new Date(c.getTimeInMillis());
		LocalTime starttime = LocalTime.parse("09:00");
		c.set(2016, Calendar.OCTOBER, 16, 9, 30, 0);
		Date enddate = new Date(c.getTimeInMillis());
		LocalTime endtime = LocalTime.parse("09:30");
		
		event = new Event();
		event.setEndDate(enddate);
		event.setStartDate(startdate);
		event.setEventId(1);
		event.setLocation(location);
		event.setStartTime(Time.valueOf(starttime));
		event.setEndTime(Time.valueOf(endtime));
		
		event1 = new Event();
		event1.setEndDate(enddate);
		event1.setStartDate(startdate);
		event1.setEventId(2);
		event1.setLocation("Toronto");
		event1.setStartTime(Time.valueOf(starttime));
		event1.setEndTime(Time.valueOf(endtime));	
	}

	@Before
	public void setMockOutput() {
		when(eventDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation)-> {
			return event;
		});
		when(eventDao.findAll()).thenAnswer( (InvocationOnMock invocation) -> {
			List<Event> events = new ArrayList<>();
			events.add(event);
			events.add(event1);
		    return events;
		  });
	}
	
	/**
	 * test successfully create mock Event
	 */
	@Test
	public void testMockEventCreation() {
		assertNotNull(event);
	}
	
	/**
	 * test successfully get one event by id return corresponding event
	 */
	@Test
	public void testGetEvent() {
		Event eventReturned = eventService.getEvent(1);
		compare(event, eventReturned);
	}
	
	/**
	 * test successfully delete one event by id
	 */
	@Test
	public void testDeleteEvent() {
		eventService.deleteEvent(1);
		verify(eventDao, times(1)).deleteById(1);
	}
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	/**
	 * test get event returns null should throw exception
	 */
	@Test 
	public void testGetEventByIdReturnNull() {
		when(eventDao.findById(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		     return null;
		  });
	     try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		exceptionRule.expect(IllegalArgumentException.class);
		exceptionRule.expectMessage("there is no such event!");
		eventService.getEvent(1);
	}
	
	
	/**
	 * test successfully get all events 
	 */
	@Test
	public void testGetAllEvents() {
		List<Event> eventsReturned = eventService.getAllEvents();
		compare(event, eventsReturned.get(0));
		compare(event1, eventsReturned.get(1));
	}
	
	/**
	 * helper method to compare two event 
	 */
	private void compare(Event eventExpected, Event eventReturned) {
		assertEquals(eventExpected.getEventId(), eventReturned.getEventId());
		assertEquals(eventExpected.getEndDate(), eventReturned.getEndDate());
		assertEquals(eventExpected.getEndTime(), eventReturned.getEndTime());
		assertEquals(eventExpected.getLocation(), eventReturned.getLocation());
		assertEquals(eventExpected.getStartTime(), eventReturned.getStartTime());
		assertEquals(eventExpected.getStartDate(), eventReturned.getStartDate());
	}
}
