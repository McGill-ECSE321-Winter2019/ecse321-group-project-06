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

	private void setSchool(String value) {
		this.school = value;
	}
	private String getSchool() {
		return this.school;
	}

	private void setGraduationDate(Date value) {
		this.graduationDate = value;
	}
	private Date getGraduationDate() {
		return this.graduationDate;
	}

	private void setStudentId(int value) {
		this.studentId=value;
	}
	@Id
	@GeneratedValue()private int getStudentId() {
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
//	public Student(String userEmail, String userPassword, String studentName, int studentId, String school, Date graduationDate) {
//		super();
//		this.studentId = studentId;
//		this.graduationDate = graduationDate;
//		this.school = school;
//	}

}
