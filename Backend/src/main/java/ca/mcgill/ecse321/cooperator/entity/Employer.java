import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.ManyToMany;
import javax.persistence.Id;

@Entity
@Table(name = "EMPLOYER")
public class Employer extends User{
private Cooperator cooperator;

@ManyToOne(optional=false)
public Cooperator getCooperator() {
   return this.cooperator;
}

public void setCooperator(Cooperator cooperator) {
   this.cooperator = cooperator;
}

private Set<Event> event;

@ManyToMany
public Set<Event> getEvent() {
   return this.event;
}

public void setEvent(Set<Event> events) {
   this.event = events;
}

private int employerId;

public void setEmployerId(int value) {
this.employerId = value;
    }
@Id
@GeneratedValue()public int getEmployerId() {
return this.employerId;
    }
private Employer (String userEmail, String userPassword, String companyName, int employerId) {
	super(userEmail, userPassword,companyName);
}

}
