package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

@Entity
@Table(name = "COOPADMIN")
public class CoopAdmin extends User{
	private int coopAdminId;
	
	private Set<CoopTerm> coopTerm = Collections.emptySet();

	public void setCoopAdminId(int value) {
		this.coopAdminId = value;
	}
	@Id
	@GeneratedValue()
	public int getCoopAdminId() {
		return this.coopAdminId;
	}
	@OneToMany(mappedBy="coopAdmin", fetch = FetchType.EAGER)
	public Set<CoopTerm> getCoopTerm() {
		return this.coopTerm;
	}

	public void setCoopTerm(Set<CoopTerm> coopTerms) {
		this.coopTerm = coopTerms;
	}
	public CoopAdmin() {
		super();
	}

}
