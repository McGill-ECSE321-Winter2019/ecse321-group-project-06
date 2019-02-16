package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Table(name = "EMPLOYER")

public class Employer extends CoopUser{
	private Set<Event> event;
	private int employerId;
	private Set<CoopTerm> coopTerm;
	
	@ManyToMany
	public Set<Event> getEvent() {
		return this.event;
	}
	public void setEvent(Set<Event> events) {
		this.event = events;
	}

	@OneToMany(mappedBy="employer")
	public Set<CoopTerm> getCoopTerm() {
		return this.coopTerm;
	}

	public void setCoopTerm(Set<CoopTerm> coopTerms) {
		this.coopTerm = coopTerms;
	}
	
	public Employer () {
		super();
	}

}