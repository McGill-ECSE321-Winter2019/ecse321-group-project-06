package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import java.util.List;
import javax.persistence.ManyToMany;


@Entity

@Table(name = "EMPLOYER")

public class Employer extends CoopUser{
	private List<Event> event;
	private List<CoopTerm> coopTerm;
	
	@ManyToMany
	public List<Event> getEvent() {
		return this.event;
	}
	public void setEvent(List<Event> events) {
		this.event = events;
	}

	@OneToMany(mappedBy="employer",cascade = CascadeType.ALL)
	public List<CoopTerm> getCoopTerm() {
		return this.coopTerm;
	}

	public void setCoopTerm(List<CoopTerm> coopTerms) {
		this.coopTerm = coopTerms;
	}
	
	public Employer () {
		super();
	}

}