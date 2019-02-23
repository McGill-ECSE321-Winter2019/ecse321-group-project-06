package ca.mcgill.ecse321.cooperator;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.controller.EventController;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Event;
import ca.mcgill.ecse321.cooperator.repository.EventRepository;
import ca.mcgill.ecse321.cooperator.service.EventService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventControllerTests {
	@Mock
	private EventRepository eventDao;
	
	@Mock
	private EventService eventService;
	
	@InjectMocks
	private EventController eventController;
	
	private Event event;
	
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
	}

	@Test
	public void testMockPersonCreation() {
		assertNotNull(event);
	}
}
