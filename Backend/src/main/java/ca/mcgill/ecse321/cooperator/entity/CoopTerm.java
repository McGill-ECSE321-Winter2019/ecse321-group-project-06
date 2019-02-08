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

	private void setLocation(String value) {
		this.location = value;
	}
	private String getLocation() {
		return this.location;
	}

	private void setAcademicSemester(String value) {
		this.academicSemester = value;
	}
	private String getAcademicSemester() {
		return this.academicSemester;
	}
	
	private void setIfWorkPermitNeeded(boolean value) {
		this.ifWorkPermitNeeded = value;
	}
	private boolean isIfWorkPermitNeeded() {
		return this.ifWorkPermitNeeded;
	}

	private void setJobDescription(String value) {
		this.jobDescription = value;
	}
	private String getJobDescription() {
		return this.jobDescription;
	}

	private void setEvaluationForm(String value) {
		this.evaluationForm = value;
	}
	private String getEvaluationForm() {
		return this.evaluationForm;
	}

	private void setCoopPlacement(String value) {
		this.coopPlacement = value;
	}
	private String getCoopPlacement() {
		return this.coopPlacement;
	}

	private void setTaxCreditForm(String value) {
		this.taxCreditForm = value;
	}
	private String getTaxCreditForm() {
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
	private Employer getEmployer() {
		return this.employer;
	}
	private void setEmployer(Employer value) {
		this.employer = value;
	}
	
	private void setCoopAdmin(CoopAdmin value) {
		this.coopAdmin = value;
	}
	@ManyToOne(optional=false)
	private CoopAdmin getCoopAdmin() {
		return this.coopAdmin;
	}

	public CoopTerm(String location, Date startDate, String academicSemester, boolean ifWorkPermitNeeded,
			String jobDescription, Student student, Employer employer, CoopAdmin coopAdmin, Date endDate) {
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.academicSemester = academicSemester;
		this.ifWorkPermitNeeded = ifWorkPermitNeeded;
		this.jobDescription = jobDescription;
		this.student = student;
		this.employer = employer;
		this.coopAdmin = coopAdmin;
	}

}
