package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.Table;
import javax.persistence.Entity;
import java.sql.Date;
import java.util.Set;
import javax.persistence.ManyToMany;
import java.sql.Time;
import javax.persistence.Id;

@Entity
@Table(name = "EVENT")
public class Event{
private Date startDate;
   
   private void setStartDate(Date value) {
this.startDate = value;
    }
private Date getStartDate() {
return this.startDate;
    }
private Date endDate;

private void setEndDate(Date value) {
this.endDate = value;
    }
private Date getEndDate() {
return this.endDate;
    }
private String location;

private void setLocation(String value) {
this.location = value;
    }
private String getLocation() {
return this.location;
    }
private Set<Employer> employer;

@ManyToMany(mappedBy="event")
public Set<Employer> getEmployer() {
   return this.employer;
}

public void setEmployer(Set<Employer> employers) {
   this.employer = employers;
}

private Time startTime;

public void setStartTime(Time value) {
this.startTime = value;
    }
public Time getStartTime() {
return this.startTime;
    }
private Time endTime;

public void setEndTime(Time value) {
this.endTime = value;
    }
public Time getEndTime() {
return this.endTime;
    }
private int eventId;

public void setEventId(int value) {
this.eventId = value;
    }
@Id
public int getEventId() {
return this.eventId;
    }
public Event (Date startDate, Date endDate, String location, Time startTime, Time endTime, int eventId) {
   this.startDate=startDate;
   this.endDate=endDate;
   this.location=location;
   this.startTime=startTime;
   this.endTime=endTime;
   this.eventId=eventId;
}

}
