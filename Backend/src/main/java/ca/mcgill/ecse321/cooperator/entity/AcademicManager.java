package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table()
public class AcademicManager extends User{
	private int academicManagerId;

	public void setAcademicManagerId(int value) {
		this.academicManagerId = value;
	}
	@Id
	@GeneratedValue()
	public int getAcademicManagerId() {
		return this.academicManagerId;
	}
	public AcademicManager() {
		super();
	}

}
