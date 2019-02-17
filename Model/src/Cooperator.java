import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class Cooperator{
private Set<CoopTerm> coopTerm;

@OneToMany(cascade={CascadeType.ALL})
public Set<CoopTerm> getCoopTerm() {
   return this.coopTerm;
}

public void setCoopTerm(Set<CoopTerm> coopTerms) {
   this.coopTerm = coopTerms;
}

private Set<Employer> CoopTerm;

@OneToMany(cascade={CascadeType.ALL})
public Set<Employer> getCoopTerm() {
   return this.CoopTerm;
}

public void setCoopTerm(Set<Employer> CoopTerms) {
   this.CoopTerm = CoopTerms;
}

private Set<Event> event;

@OneToMany(cascade={CascadeType.ALL})
public Set<Event> getEvent() {
   return this.event;
}

public void setEvent(Set<Event> events) {
   this.event = events;
}

}
