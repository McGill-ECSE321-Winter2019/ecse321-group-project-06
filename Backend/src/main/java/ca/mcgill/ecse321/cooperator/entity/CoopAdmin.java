package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "COOPADMIN")
public class CoopAdmin extends User{
	private Cooperator cooperator;
	private int coopAdminId;
	
	@ManyToOne(optional=false)
	public Cooperator getCooperator() {
		return this.cooperator;
	}

	public void setCooperator(Cooperator cooperator) {
		this.cooperator = cooperator;
	}

	public void setCoopAdminId(int value) {
		this.coopAdminId = value;
	}
	@Id
	@GeneratedValue()
	public int getCoopAdminId() {
		return this.coopAdminId;
	}
	public CoopAdmin(String userEmail, String userPassword, String adminName) {
		super(userEmail, userPassword,adminName);
	}

}
