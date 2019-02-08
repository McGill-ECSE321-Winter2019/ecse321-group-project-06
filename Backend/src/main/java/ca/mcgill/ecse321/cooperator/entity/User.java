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
	
	public User(String email, String password, String name) {
		this.email = email;
		this.password = password;
		this.name = name;
	}

	private void setEmail(String value) {
		this.email = value;
	}
	private String getEmail() {
		return this.email;
	}

	private void setPassword(String value) {
		this.password = value;
	}
	private String getPassword() {
		return this.password;
	}

	private void setName(String value) {
		this.name = value;
	}
	private String getName() {
		return this.name;
	}

}
