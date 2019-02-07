package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "COOPADMIN")
public class CoopAdmin extends User{
	private int coopAdminId;

	public void setCoopAdminId(int value) {
		this.coopAdminId = value;
	}
	@Id
	public int getCoopAdminId() {
		return this.coopAdminId;
	}
	
	public CoopAdmin(String userEmail, String userPassword, String adminName, int coopAdminId) {
		super(userEmail, userPassword,adminName);
	}

}
