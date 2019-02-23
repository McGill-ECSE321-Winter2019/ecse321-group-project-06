package ca.mcgill.ecse321.cooperator.dto;

import java.util.Date;

public class CoopTermDto {
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
	private EmployerDto employer;
	
	public CoopTermDto() {
		
	}
	
	public CoopTermDto(Date startDate, Date endDate, String location, String academicSemester,
			boolean ifWorkPermitNeeded, String jobDescription, String evaluationForm, String coopPlacement,
			String taxCreditForm, int coopTermId, EmployerDto employer) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.academicSemester = academicSemester;
		this.ifWorkPermitNeeded = ifWorkPermitNeeded;
		this.jobDescription = jobDescription;
		this.evaluationForm = evaluationForm;
		this.coopPlacement = coopPlacement;
		this.taxCreditForm = taxCreditForm;
		this.coopTermId = coopTermId;
		this.employer = employer;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public String getLocation() {
		return location;
	}

	public String getAcademicSemester() {
		return academicSemester;
	}

	public boolean isIfWorkPermitNeeded() {
		return ifWorkPermitNeeded;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public String getEvaluationForm() {
		return evaluationForm;
	}

	public String getCoopPlacement() {
		return coopPlacement;
	}

	public String getTaxCreditForm() {
		return taxCreditForm;
	}

	public int getCoopTermId() {
		return coopTermId;
	}

	public EmployerDto getEmployer() {
		return employer;
	}
	
}
