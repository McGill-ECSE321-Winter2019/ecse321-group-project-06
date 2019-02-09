package ca.mcgill.ecse321.cooperator.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalTime;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.entity.Event;
import ca.mcgill.ecse321.cooperator.repository.EventRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceTest {
	@Autowired
	private EventService eventService;
	@Autowired
	private EventRepository eventRepository;

 	@After
	public void clearDatabase() {	
		eventRepository.deleteAll();
	}

 	@Test
	public void testCreateEvent() {
		assertEquals(0, eventService.getAllEvents().size());
		
		Calendar c = Calendar.getInstance();
 		Date startdate = new Date();
		Date enddate = new Date();
		String location = "location";
		Time starttime = new Time(c.getTimeInMillis());
		Time endtime = new Time(c.getTimeInMillis());
		Event event = null;
		try {
			event = eventService.createEvent(startdate, enddate, location,starttime,endtime);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

 		List<Event> allevents = eventService.getAllEvents();

 		assertEquals(1, allevents.size());

 		assertEquals(startdate, event.getStartDate());
		assertEquals(enddate, event.getEndDate());
		assertEquals(location, event.getLocation());
		assertEquals(starttime, event.getStartTime());
		assertEquals(endtime, event.getEndTime());


	}

 	@Test
	public void testCreateEventWithNullStartDate() {
		assertEquals(0, eventService.getAllEvents().size());
		
		Calendar c = Calendar.getInstance();
		Date startdate = null;
		Date enddate = new Date();
		String location = "location";
		Time starttime = new Time(c.getTimeInMillis());
		Time endtime = new Time(c.getTimeInMillis());

 		Event event = null;
		String error = null;
		try {
			event = eventService.createEvent(startdate, enddate, location,starttime,endtime);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("startDate cannot be empty!", error);

 		assertEquals(0, eventService.getAllEvents().size());
	}

 	@Test
	public void testCreateCoopAdminWithNullEndDate() {
		assertEquals(0, eventService.getAllEvents().size());
		
		Calendar c = Calendar.getInstance();
		Date startdate = new Date();
		Date enddate = null;
		String location = "location";
		Time starttime = new Time(c.getTimeInMillis());
		Time endtime = new Time(c.getTimeInMillis());

 		Event event = null;
		String error = null;
		try {
			event = eventService.createEvent(startdate, enddate, location,starttime,endtime);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("endDate cannot be empty!", error);

 		assertEquals(0, eventService.getAllEvents().size());
	}

 	@Test
	public void testCreateCoopAdminWithNullLocation() {
		assertEquals(0, eventService.getAllEvents().size());
		Calendar c = Calendar.getInstance();
		Date startdate = new Date();
		Date enddate = new Date();
		String location = null;
		Time starttime = new Time(c.getTimeInMillis());
		Time endtime = new Time(c.getTimeInMillis());

 		Event event = null;
		String error = null;
		try {
			event = eventService.createEvent(startdate, enddate, location,starttime,endtime);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("location cannot be empty!", error);

 		assertEquals(0, eventService.getAllEvents().size());
	}
 	@Test
	public void testCreateEventWithNullStartTime() {
		assertEquals(0, eventService.getAllEvents().size());
		Calendar c = Calendar.getInstance();
		Date startdate = new Date(c.getTimeInMillis());
		Date enddate = new Date(c.getTimeInMillis());
		String location = "location";
		Time starttime = null;
		Time endtime = new Time(c.getTimeInMillis());

 		Event event = null;
		String error = null;
		try {
			event = eventService.createEvent(startdate, enddate, location,starttime,endtime);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("startTime cannot be empty!", error);

 		assertEquals(0, eventService.getAllEvents().size());
	}
 	@Test
	public void testCreateEventWithNullEndTime() {
		assertEquals(0, eventService.getAllEvents().size());
		
		Calendar c = Calendar.getInstance();
		Date startdate = new Date();
		Date enddate = new Date();
		String location = "location";
		Time starttime = new Time(c.getTimeInMillis());
		Time endtime = null;

 		Event event = null;
		String error = null;
		try {
			event = eventService.createEvent(startdate, enddate, location,starttime,endtime);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}
		assertEquals("endTime cannot be empty!", error);

 		assertEquals(0, eventService.getAllEvents().size());
	}
}