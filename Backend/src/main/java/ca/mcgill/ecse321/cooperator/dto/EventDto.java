package ca.mcgill.ecse321.cooperator.dto;

import java.sql.Time;
import java.util.Date;

public class EventDto {
	private Date startDate;
	private Date endDate;
	private String location;
	private Time startTime;
	private Time endTime;
	private int eventId;
	
	public EventDto() {
		
	}
	
	public EventDto(Date startDate, Date endDate, String location,
			Time startTime, Time endTime, int eventId) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.startTime = startTime;
		this.endTime = endTime;
		this.eventId = eventId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getLocation() {
		return location;
	}

	public Time getStartTime() {
		return startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public int getEventId() {
		return eventId;
	}
	
}
