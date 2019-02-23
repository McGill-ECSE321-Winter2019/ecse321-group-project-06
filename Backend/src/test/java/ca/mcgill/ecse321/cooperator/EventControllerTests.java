package ca.mcgill.ecse321.cooperator;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.controller.EventController;
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

public class EventControllerTests {
	@Mock
	private EventRepository employerDao;
	
	@Mock
	private EventService eventService;
	
	@InjectMocks
	private EventController eventController;
	
	private Event event;
	
}
