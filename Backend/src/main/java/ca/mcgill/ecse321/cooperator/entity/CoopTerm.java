package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Entity;

import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
@Table(name = "COOPTERM")
public class CoopTerm{
	private Date endDate;
	private Date startDate;
	private String location;
	private String academicSemester;
	private boolean ifWorkPermitNeeded;
	private String jobDescription;
	private String evaluationForm;
	private String coopPlacement;
	private String taxCreditForm;
	private Student student;
	private int coopTermId;
	private Employer employer;
	private CoopAdmin coopAdmin;

	//@ManyToOne(optional=false)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	//@ManyToOne(optional=false)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setLocation(String value) {
		this.location = value;
	}
	public String getLocation() {
		return this.location;
	}

	public void setAcademicSemester(String value) {
		this.academicSemester = value;
	}
	public String getAcademicSemester() {
		return this.academicSemester;
	}
	
	public void setIfWorkPermitNeeded(boolean value) {
		this.ifWorkPermitNeeded = value;
	}
	public boolean isIfWorkPermitNeeded() {
		return this.ifWorkPermitNeeded;
	}

	public void setJobDescription(String value) {
		this.jobDescription = value;
	}
	public String getJobDescription() {
		return this.jobDescription;
	}

	public void setEvaluationForm(String value) {
		this.evaluationForm = value;
	}
	public String getEvaluationForm() {
		return this.evaluationForm;
	}

	public void setCoopPlacement(String value) {
		this.coopPlacement = value;
	}
	public String getCoopPlacement() {
		return this.coopPlacement;
	}

	public void setTaxCreditForm(String value) {
		this.taxCreditForm = value;
	}
	public String getTaxCreditForm() {
		return this.taxCreditForm;
	}

	@ManyToOne(optional=false)
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	public void setcoopTermId(int value) {
		this.coopTermId = value;
	}
	@Id
	@GeneratedValue()
	public int getcoopTermId() {
		return this.coopTermId;
	}
	@ManyToOne(optional=false)
	public Employer getEmployer() {
		return this.employer;
	}
	public void setEmployer(Employer value) {
		this.employer = value;
	}
	
	public void setCoopAdmin(CoopAdmin value) {
		this.coopAdmin = value;
	}
	@ManyToOne
	public CoopAdmin getCoopAdmin() {
		return this.coopAdmin;
	}
	
	public CoopTerm() {
		
	}

//	public CoopTerm(String location, Date startDate, String academicSemester, boolean ifWorkPermitNeeded,
//			String jobDescription, Student student, Employer employer, CoopAdmin coopAdmin, Date endDate) {
//		this.location = location;
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.academicSemester = academicSemester;
//		this.ifWorkPermitNeeded = ifWorkPermitNeeded;
//		this.jobDescription = jobDescription;
//		this.student = student;
//		this.employer = employer;
//		this.coopAdmin = coopAdmin;
//	}

}
