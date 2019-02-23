package ca.mcgill.ecse321.cooperator.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private int coopTermId;
	private Employer employer;
	private Student student;

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

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
	
	public void setCoopTermId(int coopTermId) {
		this.coopTermId = coopTermId;
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
	
	@ManyToOne(optional=false)
	public Student getStudent() {
		return this.student;
	}
	
	public void setStudent(Student value) {
		this.student = value;
	}
	
	public CoopTerm() {
		
	}
}
