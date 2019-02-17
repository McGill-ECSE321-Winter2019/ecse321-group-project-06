package ca.mcgill.ecse321.cooperator.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
 	
	/* Test creating event, should not throw exception */
 	@Test
	public void testCreateEvent() {
		assertEquals(0, eventService.getAllEvents().size());
		
		Calendar c = Calendar.getInstance();
		String location = "location";
		c.set(2016, Calendar.OCTOBER, 16, 9, 00, 0);
 		Date startdate = new Date(c.getTimeInMillis());
		LocalTime starttime = LocalTime.parse("09:00");
		c.set(2016, Calendar.OCTOBER, 16, 9, 30, 0);
		Date enddate = new Date(c.getTimeInMillis());
		LocalTime endtime = LocalTime.parse("09:30");
		Event event = null;
		try {
			event = eventService.createEvent(startdate, enddate, location,Time.valueOf(starttime),Time.valueOf(endtime));
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

 		List<Event> allevents = eventService.getAllEvents();

 		assertEquals(1, allevents.size());
 		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
 		assertEquals(startdate, allevents.get(0).getStartDate());
		assertEquals(enddate, allevents.get(0).getEndDate());
		assertEquals(location, allevents.get(0).getLocation());
		assertEquals(starttime.format(formatter).toString(), allevents.get(0).getStartTime().toString());
		assertEquals(endtime.format(formatter).toString(), allevents.get(0).getEndTime().toString());


	}
 	
	/* Test creating event with no start date provided, should throw exception */
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
			error = e.getMessage();
		}
		assertEquals("startDate cannot be empty!", error);
 		assertEquals(0, eventService.getAllEvents().size());
	}

	/* Test creating event with no end date provided, should throw exception */
 	@Test
	public void testCreateEventWithNullEndDate() {
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
			error = e.getMessage();
		}
		assertEquals("endDate cannot be empty!", error);
 		assertEquals(0, eventService.getAllEvents().size());
	}

	/* Test creating event with no location provided, should throw exception */
 	@Test
	public void testCreateEventWithNullLocation() {
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
			error = e.getMessage();
		}
		assertEquals("location cannot be empty!", error);
 		assertEquals(0, eventService.getAllEvents().size());
	}
 	
	/* Test creating event with no start time provided, should throw exception */
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
			error = e.getMessage();
		}
		assertEquals("startTime cannot be empty!", error);
 		assertEquals(0, eventService.getAllEvents().size());
	}
 	
	/* Test creating event with no end time provided, should throw exception */
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
			error = e.getMessage();
		}
		assertEquals("endTime cannot be empty!", error);
 		assertEquals(0, eventService.getAllEvents().size());
	}
}