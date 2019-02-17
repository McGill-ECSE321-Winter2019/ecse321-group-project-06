import javax.persistence.Entity;
import java.sql.Date;
import java.util.Set;
import javax.persistence.ManyToMany;
import java.sql.Time;
import javax.persistence.ManyToOne;

@Entity
public class Event{
private Date startDate;
   
   public void setStartDate(Date value) {
      this.startDate = value;
   }
   
   public Date getStartDate() {
      return this.startDate;
   }
   
   private Date endDate;
   
   public void setEndDate(Date value) {
      this.endDate = value;
   }
   
   public Date getEndDate() {
      return this.endDate;
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
   
private String location;

public void setLocation(String value) {
    this.location = value;
}
public String getLocation() {
    return this.location;
}
private Set<Employer> employer;

@ManyToMany(mappedBy="event" )
public Set<Employer> getEmployer() {
   return this.employer;
}

public void setEmployer(Set<Employer> employers) {
   this.employer = employers;
}
   
   public Event () {
      // TODO implement this operation
      throw new UnsupportedOperationException("not implemented");
   }
   
   }
