package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.Table;
import javax.persistence.Entity;
import java.sql.Date;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
@Table(name = "COOPTERM")
public class CoopTerm{
private Date endDate;

@ManyToOne(optional=false)
public Date getEndDate() {
   return this.endDate;
}

public void setEndDate(Date endDate) {
   this.endDate = endDate;
}

private Date startDate;

@ManyToOne(optional=false)
public Date getStartDate() {
   return this.startDate;
}

public void setStartDate(Date startDate) {
   this.startDate = startDate;
}

private String location;
   
   private void setLocation(String value) {
this.location = value;
    }
private String getLocation() {
return this.location;
    }
private String academicSemester;

private void setAcademicSemester(String value) {
this.academicSemester = value;
    }
private String getAcademicSemester() {
return this.academicSemester;
    }
private boolean ifWorkPermitNeeded;

private void setIfWorkPermitNeeded(boolean value) {
this.ifWorkPermitNeeded = value;
    }
private boolean isIfWorkPermitNeeded() {
return this.ifWorkPermitNeeded;
    }
private String jobDescription;

private void setJobDescription(String value) {
this.jobDescription = value;
    }
private String getJobDescription() {
return this.jobDescription;
    }
private String evaluationForm;

private void setEvaluationForm(String value) {
this.evaluationForm = value;
    }
private String getEvaluationForm() {
return this.evaluationForm;
    }
private String coopPlacement;

private void setCoopPlacement(String value) {
this.coopPlacement = value;
    }
private String getCoopPlacement() {
return this.coopPlacement;
    }
private String taxCreditForm;

private void setTaxCreditForm(String value) {
this.taxCreditForm = value;
    }
private String getTaxCreditForm() {
return this.taxCreditForm;
    }
private Student student;

@ManyToOne(optional=false)
public Student getStudent() {
   return this.student;
}

public void setStudent(Student student) {
   this.student = student;
}

private int coopTermId;

public void setCoopTermId(int value) {
this.coopTermId = value;
    }
@Id
public int getCoopTermId() {
return this.coopTermId;
    }
private Employer employer;
private Employer getEmployer() {
return this.employer;
    }
private CoopAdmin coopAdmin;
private void setCoopAdmin(CoopAdmin value) {
this.coopAdmin = value;
    }
private CoopAdmin getCoopAdmin() {
return this.coopAdmin;
    }

public CoopTerm(String location, Date startDate, String academicSemester, boolean ifWorkPermitNeeded,
		String jobDescription, Student student, Employer employer, CoopAdmin coopAdmin, int coopTermId, Date endDate) {
	super();
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
