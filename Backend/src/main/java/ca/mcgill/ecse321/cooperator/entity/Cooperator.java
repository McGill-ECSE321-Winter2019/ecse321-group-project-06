package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class Cooperator{
	private Set<Student> student;
	private Set<CoopTerm> coopTerm;
	private Set<CoopAdmin> coopAdmin;
	private Set<Event> event;
	private Set<AcademicManager> academicManager;
	private Set<Employer> employer;
	private Set<User> user;

	@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
	public Set<Student> getStudent() {
		return this.student;
	}

	public void setStudent(Set<Student> students) {
		this.student = students;
	}

	@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
	public Set<CoopTerm> getCoopTerm() {
		return this.coopTerm;
	}

	public void setCoopTerm(Set<CoopTerm> coopTerms) {
		this.coopTerm = coopTerms;
	}

	@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
	public Set<CoopAdmin> getCoopAdmin() {
		return this.coopAdmin;
	}

	public void setCoopAdmin(Set<CoopAdmin> coopAdmins) {
		this.coopAdmin = coopAdmins;
	}

	@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
	public Set<Event> getEvent() {
		return this.event;
	}

	public void setEvent(Set<Event> events) {
		this.event = events;
	}

	@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
	public Set<AcademicManager> getAcademicManager() {
		return this.academicManager;
	}

	public void setAcademicManager(Set<AcademicManager> academicManagers) {
		this.academicManager = academicManagers;
	}

	@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
	public Set<Employer> getEmployer() {
		return this.employer;
	}

	public void setEmployer(Set<Employer> employers) {
		this.employer = employers;
	}

	@OneToMany(mappedBy="cooperator", cascade={CascadeType.ALL})
	public Set<User> getUser() {
		return this.user;
	}

	public void setUser(Set<User> users) {
		this.user = users;
	}

}
