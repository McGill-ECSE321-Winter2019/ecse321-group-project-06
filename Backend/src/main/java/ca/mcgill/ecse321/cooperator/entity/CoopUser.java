package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "COOPUSER")
@Inheritance(
	    strategy = InheritanceType.JOINED
	)
public abstract class CoopUser{

	private String email;
	private String password;
	private String name;
	private int coopUserId;
	
	public CoopUser() {
	}
	public void setEmail(String value) {
		this.email = value;
	}
	public String getEmail() {
		return this.email;
	}	
	public void setCoopUserId(int coopTermId) {
		this.coopUserId = coopTermId;
	}
	@Id
	@GeneratedValue()
	public int getCoopUserId() {
		return this.coopUserId;
	}
	public void setPassword(String value) {
		this.password = value;
	}
	public String getPassword() {
		return this.password;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	public String getName() {
		return this.name;
	}

}