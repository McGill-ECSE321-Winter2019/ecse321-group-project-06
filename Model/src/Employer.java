import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@Entity
public class Employer extends User{
private Set<CoopTerm> coopTerm;
   
   @OneToMany(mappedBy="employer" )
   public Set<CoopTerm> getCoopTerm() {
      return this.coopTerm;
   }
   
   public void setCoopTerm(Set<CoopTerm> coopTerms) {
      this.coopTerm = coopTerms;
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
public int getEmployerId() {
    return this.employerId;
}
   
   public Employer () {
      // TODO implement this operation
      throw new UnsupportedOperationException("not implemented");
   }
   
   }
