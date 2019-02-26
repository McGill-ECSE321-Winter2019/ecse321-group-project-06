package ca.mcgill.ecse321.cooperator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.cooperator.dto.EventDto;
import ca.mcgill.ecse321.cooperator.entity.Event;
import ca.mcgill.ecse321.cooperator.service.EventService;

@CrossOrigin(origins = "*")
@RestController
public class EventController {
	@Autowired
	private EventService eventService;
	
	@GetMapping(value = {"/events", "/events/"})
	public List<EventDto> getEvents(){
		List<EventDto> events = new ArrayList<>();
		for(Event event: eventService.getAllEvents()) {
			events.add(convertToEventDto(event));
		}
		return events;
	}
	
	@PostMapping(value = {"/events", "/events/"})
	public EventDto createEvent(@RequestBody Event event) {
		if(event != null) {
			Event eventCreated = eventService.createEvent(event.getStartDate(), event.getEndDate(), event.getLocation(), event.getStartTime(), event.getEndTime());
			return convertToEventDto(eventCreated);
		}
		//TODO if event is null, throw exception
		return null;
	}
	
	private EventDto convertToEventDto(Event event) {
		EventDto eventDto = new EventDto(event.getStartDate(), event.getEndDate(),event.getLocation(), event.getStartTime(), event.getEndTime(), event.getEventId());
		return eventDto;
	}
	
}
