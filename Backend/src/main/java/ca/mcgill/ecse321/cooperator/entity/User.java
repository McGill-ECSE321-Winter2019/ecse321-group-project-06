package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

public abstract class User{

	private String email;
	private String password;
	private String name;
	
	public User() {
//		this.email = email;
//		this.password = password;
//		this.name = name;
	}

	public void setEmail(String value) {
		this.email = value;
	}
	public String getEmail() {
		return this.email;
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
