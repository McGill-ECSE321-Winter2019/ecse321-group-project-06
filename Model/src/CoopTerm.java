import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CoopTerm{
private State state;
   
   public void setState(State value) {
      this.state = value;
   }
   
   public State getState() {
      return this.state;
   }
   
   private Employer employer;
   
   @ManyToOne(optional=false)
   public Employer getEmployer() {
      return this.employer;
   }
   
   public void setEmployer(Employer employer) {
      this.employer = employer;
   }
   
   private String location;

public void setLocation(String value) {
    this.location = value;
}
public String getLocation() {
    return this.location;
}
private String startDate;

public void setStartDate(String value) {
    this.startDate = value;
}
public String getStartDate() {
    return this.startDate;
}
private String endDate;

public void setEndDate(String value) {
    this.endDate = value;
}
public String getEndDate() {
    return this.endDate;
}
private String acdemicSemester;

public void setAcdemicSemester(String value) {
    this.acdemicSemester = value;
}
public String getAcdemicSemester() {
    return this.acdemicSemester;
}
private boolean ifWorkPermitNeeded;

public void setIfWorkPermitNeeded(boolean value) {
    this.ifWorkPermitNeeded = value;
}
public boolean isIfWorkPermitNeeded() {
    return this.ifWorkPermitNeeded;
}
private String jobDestription;

public void setJobDestription(String value) {
    this.jobDestription = value;
}
public String getJobDestription() {
    return this.jobDestription;
}
private String evaluationForm;

public void setEvaluationForm(String value) {
    this.evaluationForm = value;
}
public String getEvaluationForm() {
    return this.evaluationForm;
}
private String coopPlacement;

public void setCoopPlacement(String value) {
    this.coopPlacement = value;
}
public String getCoopPlacement() {
    return this.coopPlacement;
}
private String taxCreditForm;

public void setTaxCreditForm(String value) {
    this.taxCreditForm = value;
}
public String getTaxCreditForm() {
    return this.taxCreditForm;
}
   
   public CoopTerm () {
      // TODO implement this operation
      throw new UnsupportedOperationException("not implemented");
   }
   
   }
