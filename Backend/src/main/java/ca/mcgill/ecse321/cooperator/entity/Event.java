package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;
import javax.persistence.ManyToMany;
import java.time.LocalTime;
import javax.persistence.Id;

@Entity
@Table(name = "EVENT")
public class Event{
	private Date startDate;
	private Date endDate;
	private String location;
	private Set<Employer> employer;
	private LocalTime startTime;
	private LocalTime endTime;
	private int eventId;

	private void setStartDate(Date value) {
		this.startDate = value;
	}
	private Date getStartDate() {
		return this.startDate;
	}
	
	private void setEndDate(Date value) {
		this.endDate = value;
	}
	private Date getEndDate() {
		return this.endDate;
	}

	private void setLocation(String value) {
		this.location = value;
	}
	private String getLocation() {
		return this.location;
	}

	@ManyToMany(mappedBy="event")
	public Set<Employer> getEmployer() {
		return this.employer;
	}

	public void setEmployer(Set<Employer> employers) {
		this.employer = employers;
	}

	public void setStartTime(LocalTime value) {
		this.startTime = value;
	}
	public LocalTime getStartTime() {
		return this.startTime;
	}

	public void setEndTime(LocalTime value) {
		this.endTime = value;
	}
	public LocalTime getEndTime() {
		return this.endTime;
	}

	public void setEventId(int value) {
		this.eventId = value;
	}
	@Id
	@GeneratedValue()
	public int getEventId() {
		return this.eventId;
	}
	public Event (Date startDate, Date endDate, String location, LocalTime startTime, LocalTime endTime) {
		this.startDate=startDate;
		this.endDate=endDate;
		this.location=location;
		this.startTime=startTime;
		this.endTime=endTime;
	}

}
