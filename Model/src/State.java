import javax.persistence.Entity;

/**
 */ @Entity
public enum State{
private String active;
   
   public void setActive(String value) {
this.active = value;
    }
public String getActive() {
return this.active;
    }
private String inactive;

public void setInactive(String value) {
this.inactive = value;
    }
public String getInactive() {
return this.inactive;
       }
   }
