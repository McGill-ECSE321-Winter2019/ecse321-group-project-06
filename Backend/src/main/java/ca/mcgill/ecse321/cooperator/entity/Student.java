package ca.mcgill.ecse321.cooperator.entity;


import java.util.Calendar;
import java.util.Date;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
@Table()
public class Student extends User{
	private int studentId;
	private String school;
	private Date graduationDate;
	private Set<CoopTerm> coopTerm;

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
	
	public void setStudentId(int value) {
		this.studentId=value;
	}
	@Id
	@GeneratedValue()public int getStudentId() {
		return this.studentId;
	}

	@OneToMany(mappedBy="student")
	public Set<CoopTerm> getCoopTerm() {
		return this.coopTerm;
	}

	public void setCoopTerm(Set<CoopTerm> coopTerms) {
		this.coopTerm = coopTerms;
	}
	
	public Student() {
		super();
	}

}