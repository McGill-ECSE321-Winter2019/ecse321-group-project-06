package ca.mcgill.ecse321.cooperator.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
@Table(name = "STUDENT")
public class Student extends CoopUser{
	private String school;
	private Date graduationDate;
	private List<CoopTerm> coopTerm;

	public void setSchool(String value) {
		this.school = value;
	}
	public String getSchool() {
		return this.school;
	}

	public void setGraduationDate(Date value) {
		this.graduationDate = value;
	}
	public Date getGraduationDate() {
		return this.graduationDate;
	}

	@OneToMany(mappedBy="student",cascade = CascadeType.ALL)
	public List<CoopTerm> getCoopTerm() {
		return this.coopTerm;
	}

	public void setCoopTerm(List<CoopTerm> coopTerms) {
		this.coopTerm = coopTerms;
	}

	public Student() {
		super();
	}

} 

