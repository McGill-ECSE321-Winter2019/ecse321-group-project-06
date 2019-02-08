import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class Cooperator{
private Set<Student> student;

@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
public Set<Student> getStudent() {
   return this.student;
}

public void setStudent(Set<Student> students) {
   this.student = students;
}

private Set<CoopTerm> coopTerm;

@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
public Set<CoopTerm> getCoopTerm() {
   return this.coopTerm;
}

public void setCoopTerm(Set<CoopTerm> coopTerms) {
   this.coopTerm = coopTerms;
}

private Set<CoopAdmin> coopAdmin;

@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
public Set<CoopAdmin> getCoopAdmin() {
   return this.coopAdmin;
}

public void setCoopAdmin(Set<CoopAdmin> coopAdmins) {
   this.coopAdmin = coopAdmins;
}

private Set<Event> event;

@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
public Set<Event> getEvent() {
   return this.event;
}

public void setEvent(Set<Event> events) {
   this.event = events;
}

private Set<AcademicManager> academicManager;

@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
public Set<AcademicManager> getAcademicManager() {
   return this.academicManager;
}

public void setAcademicManager(Set<AcademicManager> academicManagers) {
   this.academicManager = academicManagers;
}

private Set<Employer> employer;

@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
public Set<Employer> getEmployer() {
   return this.employer;
}

public void setEmployer(Set<Employer> employers) {
   this.employer = employers;
}

private Set<User> user;

@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
public Set<User> getUser() {
   return this.user;
}

public void setUser(Set<User> users) {
   this.user = users;
}

}
