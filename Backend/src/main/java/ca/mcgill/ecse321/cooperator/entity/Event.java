package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.util.Date;
import java.util.Set;
import javax.persistence.ManyToMany;

import java.sql.Time;
import java.time.LocalTime;
import javax.persistence.Id;

@Entity
@Table(name = "EVENT")
public class Event{
	private Date startDate;
	private Date endDate;
	private String location;
	private Set<Employer> employer;
	private Time startTime;
	private Time endTime;
	private int eventId;

	public void setStartDate(Date value) {
		this.startDate = value;
	}
	public Date getStartDate() {
		return this.startDate;
	}
	
	public void setEndDate(Date value) {
		this.endDate = value;
	}
	public Date getEndDate() {
		return this.endDate;
	}

	public void setLocation(String value) {
		this.location = value;
	}
	public String getLocation() {
		return this.location;
	}

	@ManyToMany(mappedBy="event", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<Employer> getEmployer() {
		return this.employer;
	}

	public void setEmployer(Set<Employer> employers) {
		this.employer = employers;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getStartTime() {
		return this.startTime;
	}

	public void setEndTime(Time value) {
		this.endTime = value;
	}
	public Time getEndTime() {
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
	public Event () {
	}

}