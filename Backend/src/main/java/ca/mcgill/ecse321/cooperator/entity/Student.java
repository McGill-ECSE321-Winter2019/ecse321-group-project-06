package ca.mcgill.ecse321.cooperator.entity;


import java.util.Calendar;
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
	private Calendar graduationDate;
	private Set<CoopTerm> coopTerm;
	private Calendar graduationMonth;
	private Calendar graduationYear;

	public void setSchool(String value) {
		this.school = value;
	}
	public String getSchool() {
		return this.school;
	}

	public void setGraduationMonth(Calendar value) {
		this.graduationMonth = value;
	}
	public Calendar getGraduationMonth() {
		return this.graduationMonth;
	}
	
	public void setGraduationYear(Calendar value) {
		this.graduationYear = value;
	}
	public Calendar getGraduationYear() {
		return this.graduationYear;
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

	/*
	public Student(int studentId, String school, Calendar graduationMonth, Calendar graduationYear) {
		super();
		this.studentId = studentId;
		this.graduationMonth = graduationMonth;
		this.graduationYear = graduationYear;
		this.school = school;
	}
	*/

}